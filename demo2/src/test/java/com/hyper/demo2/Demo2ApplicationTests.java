package com.hyper.demo2;

import com.hyper.demo2.mapper.EmpMapper;
import com.hyper.demo2.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testdelete(){
        empMapper.delete(17);
    }

    @Test
    public void inserttest(){
        Emp emp =new Emp();
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("2.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);

        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());

    }

    @Test
    public void updatetest(){
        Emp emp =new Emp();

        emp.setId(18);
        emp.setUsername("Tom7");
        emp.setName("汤姆7");
        emp.setImage("26.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);

        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);

    }

    @Test
    public void getByid(){
        Emp emp =empMapper.getByid(5);
        System.out.println(emp);
    }

    @Test
    public void testList(){
        List<Emp> empList=empMapper.list("张",null,null,null);
        System.out.println(empList);
    }

    @Test
    public void Testupdate2(){
        Emp emp =new Emp();

        emp.setId(3);
        emp.setUsername("Tom74");
        emp.setName("汤姆74");
        emp.setUpdateTime(LocalDateTime.now());


        empMapper.update2(emp);

    }

    @Test
    public void DeleteByids(){
        List<Integer> ids= Arrays.asList(13,14,15);
        empMapper.deleteByids(ids);

    }


}
