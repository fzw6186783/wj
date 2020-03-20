package com.evan.wj.dao;

import com.evan.wj.bean.JotterArticle;
import org.apache.ibatis.annotations.*;
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
@Insert("insert into jotter_article values(default,#{j.articleTitle},#{j.articleContentHtml},#{j.articleContentMd},#{j.articleAbstract},#{j.articleCover},#{j.articleDate})")
    public void add(@Param("j") JotterArticle j);
@Update("update jotter_article set article_title=#{j.articleTitle},article_content_html=#{j.articleContentHtml},article_content_md=#{j.articleContentMd},article_abstract=#{j.articleAbstract},article_cover=#{j.articleCover},article_date=#{j.articleDate}" +
        "where id=#{j.id}")
    public void update(@Param("j") JotterArticle j);


}
