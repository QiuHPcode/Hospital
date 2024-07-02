package com.example.hos.service.impl;

import com.example.hos.entity.Hyq;
import com.example.hos.mapper.HyqMapper;
import com.example.hos.service.HyqService;
import com.example.hos.util.photo.BasetoPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HyqServiceImpl implements HyqService {
    @Autowired
    private HyqMapper hyqMapper;

    @Override
    public List<Hyq> getAllHyq() {
        List<Hyq> allHyq = hyqMapper.getAllHyq();
        for (Hyq hyq : allHyq){
            try {
                String imagebase = BasetoPhoto.convertToBase64(hyq.getHpo());
                hyq.setHpo(imagebase);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return allHyq;
    }
}
