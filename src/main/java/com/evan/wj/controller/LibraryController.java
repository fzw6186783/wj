package com.evan.wj.controller;

import com.evan.wj.bean.Book;
import com.evan.wj.service.BookService;

import com.gm.wj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.find(null,null,null);
    }

    @PostMapping("/api/admin/content/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.update(book);
        return book;
    }

    @PostMapping("/api/admin/content/books/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.delete(book);
    }


    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.find(null,null,cid);
        } else {
            return list();
        }
    }

    @GetMapping("/api/search")
    public List<Book> listByName(String keywords) throws Exception {
        if(keywords==null){return null;}
       return bookService.find(keywords,keywords,null);//dongtaisql 有bug
    }

    @CrossOrigin
    @PostMapping("api/admin/content/books/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "c:/Users/86156/Desktop/image/";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}

