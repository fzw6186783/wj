package com.evan.wj.service;

import com.evan.wj.bean.Category;
import com.evan.wj.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategroyService {
    @Autowired
    CategoryDao ct;

    public List<Category> findAll(){

        return ct.findAll();
    }
    public List<Category> findByName(String name){
        return ct.findByName(name);
    }
    public List<Category> findById(Integer id){
        return ct.findById(id);
    }
}
