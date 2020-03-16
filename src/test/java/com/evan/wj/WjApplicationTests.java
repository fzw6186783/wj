package com.evan.wj;

import com.evan.wj.bean.Book;
import com.evan.wj.bean.Category;
import com.evan.wj.service.BookService;
import com.evan.wj.service.CategroyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WjApplicationTests {
@Autowired
//    CategroyService cs;
    BookService bs;
    @Test
    void contextLoads() {
        Category ca=new Category();
        ca.setId(3);
         Book book=new Book();book.setCategory(ca);
      book.setTitle("a");
       System.out.println(bs.find("互","余",0));
        System.out.println(bs.find("互","余",0).size());
//        bs.add(book);

    }

}
