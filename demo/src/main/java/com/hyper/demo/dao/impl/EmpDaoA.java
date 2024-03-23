package com.hyper.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hyper.demo.dao.Empdao;
import com.hyper.demo.pojo.Emp;
import com.hyper.utils.XmlParserUtils;

@Component
public class EmpDaoA implements Empdao{

    @Override
    public List<Emp> listEmp() {

        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> emplist = XmlParserUtils.parse(file, Emp.class);

        return emplist;
    }
    

    
}
