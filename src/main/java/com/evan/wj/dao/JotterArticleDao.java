package com.evan.wj.dao;

import com.evan.wj.bean.JotterArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface JotterArticleDao {
@Select("select * from jotter_article")
@Results({
        @Result(property="id",column="id"),
        @Result(property="articleTitle",column="article_title"),
        @Result(property="articleContentHtml",column="article_content_html"),
        @Result(property="articleContentMd",column="article_content_md"),
        @Result(property="articleAbstract",column="article_abstract"),
        @Result(property="articleCover",column="article_cover"),
        @Result(property="articleDate",column="article_date")
})
    public List<JotterArticle> findAll();
@Select("select * from jotter_article where id=#{id}")
@Results({
        @Result(property="id",column="id"),
        @Result(property="articleTitle",column="article_title"),
        @Result(property="articleContentHtml",column="article_content_html"),
        @Result(property="articleContentMd",column="article_content_md"),
        @Result(property="articleAbstract",column="article_abstract"),
        @Result(property="articleCover",column="article_cover"),
        @Result(property="articleDate",column="article_date")
})
    public  JotterArticle  findById(Integer id);


}
