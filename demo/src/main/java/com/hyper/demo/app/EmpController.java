package com.hyper.demo.app;

import java.security.PublicKey;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyper.demo.pojo.Emp;
import com.hyper.demo.pojo.Result;
import com.hyper.utils.XmlParserUtils;
import java.util.*;

@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result list(){
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> emplist = XmlParserUtils.parse(file, Emp.class);

        emplist.stream().forEach(emp->{
            String gender =emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
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

        return Result.success(emplist);



        

        
        
    }


}
