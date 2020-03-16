package com.evan.wj.service;

import com.evan.wj.bean.Book;
import com.evan.wj.bean.Category;
import com.evan.wj.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bd;

    public List<Book> find(String bookname, String authorname, Integer ca){
        return bd.find(bookname,authorname,ca);
    }
    public void add(Book book){
        bd.add(book);
    }
    public void update(Book book){
        Book a=bd.exist(book.getId());
        if(a!=null){
        bd.update(book);}
        else{
            bd.add(book);
        }
    }
    public void delete(Book book){
        bd.delete(book);
    }
}
