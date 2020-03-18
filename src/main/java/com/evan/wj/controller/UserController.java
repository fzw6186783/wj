package com.evan.wj.controller;

import com.evan.wj.bean.User;
import com.evan.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/api/admin/user")
    public List<User> listUsers() {
        return userService.findAll();
    }

}
