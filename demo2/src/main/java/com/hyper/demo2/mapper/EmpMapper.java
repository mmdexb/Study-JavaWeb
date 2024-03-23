package com.hyper.demo2.mapper;

import com.hyper.demo2.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //根据id删除数据
    @Delete("delete from emp where id=#{id}")
    public void delete(Integer id);

    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "value (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    public void insert(Emp emp);

    @Update("update emp set username =#{username},name=#{name},gender=#{gender}," +
            "image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id};")
    public void update(Emp emp);


//    @Results(value = {
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
//    @Select("select * from emp where id=#{id}")
//    public Emp getByid(Integer id);

    @Select("select * from emp where id=#{id}")
    public Emp getByid(Integer id);


    @Select("select * from emp where name like '%${name}%' and gender=#{gender} and entrydate" +
            " between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);
}
