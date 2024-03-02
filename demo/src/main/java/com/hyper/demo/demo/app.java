package com.hyper.demo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class app {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello SpringBoot");
        return "hello SpringBoot";
    }


    
}
