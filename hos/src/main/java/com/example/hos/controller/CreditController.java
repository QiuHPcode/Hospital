package com.example.hos.controller;


import com.example.hos.entity.User;
import com.example.hos.service.YyrecordService;
import com.example.hos.util.common.Result;
import com.example.hos.vo.CreditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class CreditController {
    @Autowired
    private YyrecordService yyrecordService;
    @PostMapping("/getcredit")
    public Result<CreditDTO> getCredit(@RequestBody User user){
        Integer uid = user.getUid();
        CreditDTO record = yyrecordService.getrecordcredit(uid);
        if(record !=null){
            return Result.success(record);
        }
        return Result.failed();
    }
}
