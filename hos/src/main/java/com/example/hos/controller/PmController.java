package com.example.hos.controller;

import com.example.hos.service.PmService;
import com.example.hos.util.common.Result;
import com.example.hos.vo.HlDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class PmController {
    @Autowired
    private PmService pmService;
    @GetMapping("/allpm")
    public Result<List<HlDTO>> getAllPm(){
        List<HlDTO> allpm = pmService.getAllpm();
        if (allpm !=null){
            return Result.success(allpm);
        }
        return Result.failed("服务器错误");
    }
}
