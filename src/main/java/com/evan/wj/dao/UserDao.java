package com.evan.wj.dao;

import com.evan.wj.bean.User;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);
    @Select("select * from user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(String username,String password);
    @Insert("insert into user (username,password,salt,name,phone,email) values(#{user.username},#{user.password},#{user.salt},#{user.name},#{user.phone},#{user.email})")
    public void add(@Param("user") User user);
    @Select("select username,id,name,phone,email,enabled from user")
    public List<User> findAll();
    @Delete("delete  from user where id=#{id} ")
    public void deleteById(Integer id);
@Update("update user set name=#{user.name},phone=#{user.phone},email=#{user.email} where id=#{user.id}")
   public void update(@Param("user") User user);




}
