package com.hyper.demo.app;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class api {
    @RequestMapping("/api")
    public String simple(HttpServletRequest request){
        String name=request.getParameter("name");
        String age=request.getParameter("age");



        return name+"的年龄是"+age;
    }

    
    
    
}
