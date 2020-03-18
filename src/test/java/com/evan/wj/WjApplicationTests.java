package com.evan.wj;

import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.Book;
import com.evan.wj.bean.Category;
import com.evan.wj.bean.JotterArticle;
import com.evan.wj.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WjApplicationTests {
@Autowired
JotterArticleService jotterArticleService;
//    AdminMenuService adminMenuService;
    //AdminPermissionService  adminPermissionService;
    @Test
    void contextLoads() {

       System.out.println( jotterArticleService.findAll(1,1));


    }

}
