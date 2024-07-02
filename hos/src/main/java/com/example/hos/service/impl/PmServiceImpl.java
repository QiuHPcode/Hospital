package com.example.hos.service.impl;

import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;
import com.example.hos.mapper.HyqMapper;
import com.example.hos.mapper.PmMapper;
import com.example.hos.service.PmService;
import com.example.hos.vo.HlDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmServiceImpl implements PmService {

    @Autowired
    PmMapper pmMapper;

    @Autowired
    HyqMapper hyqMapper;

    @Override
    public List<HlDTO> getAllpm() {
        List<HlDTO> result = new ArrayList<>();
        List<Hyq> allHyq = hyqMapper.getAllHyq();
        for (Hyq hyq : allHyq){
            List<Partment> partments = pmMapper.getpmBYHid(hyq.getHid());
            HlDTO hlDTO = new HlDTO(hyq, partments);
            result.add(hlDTO);
        }
        return result;
    }
}
