package com.example.hos.controller;


import com.example.hos.entity.Hyq;
import com.example.hos.service.HyqService;
import com.example.hos.util.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin

public class HyqController {
    @Autowired
    private HyqService hyqService;

    @GetMapping("/hyq")
    public Result<List<Hyq>> GetHyq(){

        List<Hyq> allHyq = hyqService.getAllHyq();
        if (allHyq !=null){
            return Result.success(allHyq);
        }
        return Result.failed("服务器错误");
    }

}
