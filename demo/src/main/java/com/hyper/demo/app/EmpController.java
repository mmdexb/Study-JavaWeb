package com.hyper.demo.app;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyper.demo.pojo.Emp;
import com.hyper.demo.pojo.Result;
import com.hyper.demo.service.Empservice;
import com.hyper.demo.service.impl.EmpserviceA;
import com.hyper.utils.XmlParserUtils;
import java.util.*;

@RestController
public class EmpController {
    
    @Autowired
    private Empservice empservice;
    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> emplist=empservice.listEmp();

        return Result.success(emplist);

        
    }


}
