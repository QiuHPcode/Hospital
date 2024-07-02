package com.example.hos.controller;


import com.example.hos.entity.User;
import com.example.hos.service.UserService;
import com.example.hos.util.common.Result;
import com.example.hos.vo.UserDTO;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.queryAllUser();
    }

    @GetMapping("/query/{id}")
    public User QueryById(@PathVariable("id") Integer uid){
        return userService.queryUserByUid(uid);
    }

    @PostMapping("/login")
    public Result<UserDTO> LoginUser(@RequestBody User user){
        try {
            String ph = user.getPh();
            String pw = user.getPw();
            User val = userService.loginVal(ph,pw);

            if(val != null){
                UserDTO userDTO = new UserDTO(val);
                return Result.success("登陆成功",userDTO);
            }
            return Result.valFailed("账号或密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("服务器错误");
        }

    }
    @PostMapping("/register")
    public Result<String> RegisterUser(@RequestBody User user){
        if(!userService.queryUserByPh(user.getPh())){
            return Result.valFailed("手机号已注册","100");
        }
        if(!userService.queryUserByIden(user.getIden())){
            return Result.valFailed("身份已被注册","200");
        }
        Integer i = userService.insertUser(user);
        System.out.println(i);
        if (i==1){
            return Result.success("注册成功");

        }
        if (i==0){
            return Result.valFailed("注册失败");
        }
        return Result.failed("服务器错误");
    }
}
//    public String LoginUser(@RequestParam("ph") String ph, @RequestParam("pw") String pw){
//        User val = userService.loginVal(ph,pw);
//        if(val != null){
//            return "登陆成功！";
//        }
//        else {
//            return "账号或密码错误!";
//        }
//    }
