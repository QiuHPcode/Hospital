package com.example.hos.controller;


import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;
import com.example.hos.entity.Yycount;
import com.example.hos.service.DocService;
import com.example.hos.util.common.Result;
import com.example.hos.vo.DocDTO;
import com.example.hos.vo.ListYy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DoctorController {
    @Autowired
    private DocService docService;
    @GetMapping("/alldoc")
    public Result<List<DocDTO>> getAllDoctor(){
        List<DocDTO> allDoc = docService.getAllDoc();
        if(allDoc != null){
            return Result.success(allDoc);
        }
        return Result.failed("服务器错误");
    }
    @PostMapping("/getpmdoc")
    public Result<ListYy> getPmDoc(@RequestBody Map<String,Integer> json){
//        System.out.println(json.get("hid"));
        Integer hid = json.get("hid");
//        System.out.println(json.get("pmid"));
        Integer pmid = json.get("pmid");
        ListYy doc = docService.getDoc(hid, pmid);
        if(doc != null){
            return Result.success(doc);
        }
        return Result.failed("服务器错误");
    }




}
