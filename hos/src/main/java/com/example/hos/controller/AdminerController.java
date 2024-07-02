package com.example.hos.controller;

import com.example.hos.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequestMapping("/admin")
public class AdminerController {

    @GetMapping("/req")
    public String TestRequest(HttpServletRequest request, HttpServletResponse response){
//        System.out.println(request.getMethod());
//        Enumeration<String> enumeration = request.getHeaderNames();
//        while (enumeration.hasMoreElements()){
//            String key =  enumeration.nextElement();
//            String value = request.getHeader(key);
//            System.out.println(key+":"+value);
//
//        }

        System.out.println("info:"+request.getPathInfo());
        System.out.println("url:"+request.getRequestURL().toString());
        System.out.println("pro:"+request.getProtocol());
        System.out.println("path:"+request.getContextPath());
        System.out.println("spath:"+request.getServletPath());
        System.out.println("uri:"+request.getRequestURI());
        System.out.println(request.getQueryString());
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));

        return "hello";
    }

    @GetMapping("/rr")
    public void tt(@RequestParam(name = "name",defaultValue = "haha") String name){
        User user = new User();
        user.setUid(1001);
        user.setName(name);
        user.setIden("16612121");
        user.setPh("3311");
        user.setPw("1511");
    }


}
