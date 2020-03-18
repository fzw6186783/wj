package com.evan.wj.service;

import com.evan.wj.bean.JotterArticle;
import com.evan.wj.dao.JotterArticleDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JotterArticleService {
@Autowired
    JotterArticleDao jotterArticleDao;
    public PageInfo<JotterArticle> findAll(int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<JotterArticle>(jotterArticleDao.findAll());

    }
    public  JotterArticle  findById(Integer id){
        return jotterArticleDao.findById(id);
    }
}
