package com.evan.wj.dao;

import com.evan.wj.bean.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryDao {
    @Select("select * from category")
    List<Category> findAll();
    @Select("select * from category where name=#{name}")
    List<Category> findByName(String name);
    @Select("select * from category where id=#{id}")
    List<Category> findById(Integer id);
}
