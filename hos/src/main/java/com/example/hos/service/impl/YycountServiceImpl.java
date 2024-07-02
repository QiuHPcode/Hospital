package com.example.hos.service.impl;

import com.example.hos.entity.Doctor;
import com.example.hos.entity.Yycount;
import com.example.hos.mapper.DocMapper;
import com.example.hos.mapper.YycountMapper;
import com.example.hos.service.YycountService;
import com.example.hos.vo.HpmidDTO;
import com.example.hos.vo.YycountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YycountServiceImpl implements YycountService {
    @Autowired
    private YycountMapper yycountMapper;
    @Autowired
    private DocMapper docMapper;

    @Override
    public Yycount getYycountByyyid(Integer yyid) {
        return yycountMapper.getYycountByYyid(yyid);
    }

    @Override
    public HpmidDTO getHidAndPmid(Integer yyid) {
        Yycount yycount = yycountMapper.getYycountByYyid(yyid);
        Integer did = yycount.getDid();
        Doctor doc = docMapper.getDocByDid(did);
        return new HpmidDTO(doc.getHid(), doc.getPmid());
    }

    @Override
    public List<YycountDTO> getDocCount(Integer did) {
        List<YycountDTO> yycountDTOList = new ArrayList<>();
        List<Yycount> yycounts = yycountMapper.getyydocByDid(did);
        for (Yycount yycount:yycounts){

            YycountDTO yycountDTO = new YycountDTO(yycount);
            yycountDTOList.add(yycountDTO);
        }

        return yycountDTOList;
    }

}
