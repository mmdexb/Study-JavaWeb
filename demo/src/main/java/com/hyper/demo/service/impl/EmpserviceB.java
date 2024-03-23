package com.hyper.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyper.demo.dao.Empdao;
import com.hyper.demo.pojo.Emp;
import com.hyper.demo.service.Empservice;

@Component
public class EmpserviceB implements Empservice{
    @Autowired
    private Empdao empdao;
    @Override
    public List<Emp> listEmp(){
        List<Emp> emplist= empdao.listEmp();

        emplist.stream().forEach(emp->{
            String gender =emp.getGender();
            if("1".equals(gender)){
                emp.setGender("man");
            }else if("2".equals(gender)){
                emp.setGender("women");
            }

            String job= emp.getJob();
            if("1".equals(job)){
                emp.setJob(job);
            }else if("2".equals(job)){
                emp.setJob(job);
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
            
        }
            
        );

        return emplist;

    }
}
