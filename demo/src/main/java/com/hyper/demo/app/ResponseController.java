package com.hyper.demo.app;

import org.springframework.web.bind.annotation.RestController;

import com.hyper.demo.pojo.Address;
import com.hyper.demo.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class ResponseController {

    @RequestMapping("/hello")
    public Result hello(){
        // return new Result(1,"success"," Hello world");
        return Result.success("Hello World");
    }

    @RequestMapping("/getAddr")
    public Result getAdr(){
        Address addr=new Address();
        addr.setProvince("山东");
        addr.setCity("青岛");

        return Result.success(addr);

    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list =new ArrayList<>();
        
        Address adr1=new Address();
        adr1.setCity("东营");
        adr1.setProvince("山东");

        Address adr2 =new Address();
        adr2.setCity("黄埔");
        adr1.setProvince("上海");

        list.add(adr2);
        list.add(adr1);


        return Result.success(list);

    }

}
