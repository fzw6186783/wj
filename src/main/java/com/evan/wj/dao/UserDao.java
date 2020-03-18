package com.evan.wj.dao;

import com.evan.wj.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);
    @Select("select * from user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(String username,String password);
    @Insert("insert into user (username,password,salt) values(#{user.username},#{user.password},#{user.salt})")
    public void add(@Param("user") User user);
    @Select("select username,id,name,phone,email,enabled from user")
    public List<User> findAll();




}
