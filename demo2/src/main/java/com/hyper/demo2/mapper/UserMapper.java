package com.hyper.demo2.mapper;

import com.hyper.demo2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询全部用户信息
    @Select("select id, name, age, gender, phone from user")
    public List<User> list();



}
