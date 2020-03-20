package com.evan.wj.controller;

import com.evan.wj.bean.Book;
import com.evan.wj.bean.JotterArticle;
import com.evan.wj.service.JotterArticleService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class JotterArticleController {
    @Autowired
    JotterArticleService jotterArticleService;
    @ResponseBody//rescontroller=this+Controller
    @GetMapping("/api/article/{size}/{page}")
    public PageInfo<JotterArticle> listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return jotterArticleService.findAll(page,size);
    }
    @ResponseBody
    @GetMapping("/api/article/{id}")
    public JotterArticle findoneArticles(@PathVariable("id") int id) {
        return jotterArticleService.findById(id);
    }
    //PathVariable处理占位符
    @ResponseBody
    @PostMapping("/api/admin/content/article")
    public void addOrupdate(@RequestBody JotterArticle jotterArticle){
        System.out.println(jotterArticle);
        jotterArticleService.addOrupdate(jotterArticle);
    }


}
