package com.example.hos.service.impl;

import com.example.hos.entity.Doctor;
import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;
import com.example.hos.entity.Yycount;
import com.example.hos.mapper.DocMapper;
import com.example.hos.mapper.HyqMapper;
import com.example.hos.mapper.PmMapper;
import com.example.hos.mapper.YycountMapper;
import com.example.hos.service.DocService;
import com.example.hos.vo.DocDTO;
import com.example.hos.vo.ListYy;
import com.example.hos.vo.YyDTO;
import com.example.hos.vo.YycountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private PmMapper pmMapper;
    @Autowired
    private HyqMapper hyqMapper;
    @Autowired
    private DocMapper docMapper;


    @Override
    public List<DocDTO> getAllDoc() {
        List<DocDTO> result = new ArrayList<>();
        List<Doctor> alldoc = docMapper.getAlldoc();
        for (Doctor doctor:alldoc){
            Hyq hyq = hyqMapper.getHyqByHid(doctor.getHid());
            Partment partment = pmMapper.getpmBYPid(doctor.getPmid());
            DocDTO docDTO = new DocDTO(hyq,partment,doctor);
            result.add(docDTO);

        }
        return result;
    }
    @Autowired
    private YycountMapper yycountMapper;
    @Override
    public ListYy getDoc(Integer hid, Integer pmid) {
        Hyq hyq = hyqMapper.getHyqByHid(hid);
        Partment partment = pmMapper.getpmBYPid(pmid);
        List<Doctor> docs = docMapper.getDocsByPmid(pmid);
        List<YyDTO> yyDTOS = new ArrayList<>();
        for (Doctor doc:docs){
            List<Yycount> yycounts = yycountMapper.getyydocByDid(doc.getDid());
            List<YycountDTO> yycountDTOS= new ArrayList<>();
            for (Yycount yycount :yycounts){
                YycountDTO yycountDTO = new YycountDTO(yycount);
                yycountDTOS.add(yycountDTO);
            }
            YyDTO yyDTO = new YyDTO(doc, yycountDTOS);
            yyDTOS.add(yyDTO);
        }

        return new ListYy(hyq, partment, yyDTOS);
    }


}
