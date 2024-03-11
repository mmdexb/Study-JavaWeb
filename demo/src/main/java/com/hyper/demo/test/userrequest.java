package com.hyper.demo.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class userrequest {
    @RequestMapping("/simpleuser")
    public String simpleUser(user user) {
        System.out.println(user);
        return "OK";
    }
    
    
}
