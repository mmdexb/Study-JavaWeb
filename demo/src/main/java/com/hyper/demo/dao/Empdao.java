package com.hyper.demo.dao;

import java.util.List;

import com.hyper.demo.pojo.Emp;

public interface Empdao {
    //获取员工列表数据
    public List<Emp> listEmp();
}
