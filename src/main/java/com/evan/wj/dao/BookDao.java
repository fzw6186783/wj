package com.evan.wj.dao;

import com.evan.wj.bean.Book;
import com.evan.wj.bean.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookDao
{
@Select("<script> select book.id,cover,title,author,date,press,abs,category.id  `category.id`,name  `category.name`from book inner join category on book.cid=category.id <where> " +
        "<if test='bookname!=null '>and title like CONCAT('%',#{bookname},'%')" +"</if>"+
        "<if test='authorname!=null '>or author like CONCAT('%',#{authorname},'%')" +"</if>" +
        "<if test='cid!=null '>and cid = #{cid}" +"</if></where>" +
        "order BY `id` DESC"+
        "</script> " )
    public List<Book> find(String bookname, String authorname, Integer cid);

   @Insert("insert into book values(default,#{book.cover},#{book.title},#{book.author},#{book.date},#{book.press},#{book.abs},#{book.category.id})")
    public void add(@Param("book") Book book);

   @Update("update book set cover=#{book.cover} ,title=#{book.title},author=#{book.author},date=#{book.date},press=#{book.press},abs=#{book.abs},cid=#{book.category.id} where id=#{book.id}")
public void update(@Param("book") Book book);

@Delete("delete from book where id=#{book.id}")
public void delete(@Param("book")Book book);

@Select("select * from book where id=#{id}")
public Book exist(Integer id);

}
