package com.evan.wj.controller;

import com.evan.wj.bean.User;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/api/admin/user")
    public List<User> listUsers() {
        return userService.findAll();
    }
    @PostMapping("/api/admin/user/delete")
    public void deleteUser(@RequestBody User user){
        System.out.println(user);
        userService.deleteById(user.getId());
        //注解@RequestParam接收的参数是来自requestHeader中，即请求头。
        //@RequestBody接收的参数是来自requestBody中，即请求体，在这里数据是在请求体里 其他的方法都是null
    }
    //PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改资源）
    //
    //Post请求：后一个请求不会把第一个请求覆盖掉。（所以Post用来增资源）
    @PutMapping("/api/admin/user")
    public Result updateUser(@RequestBody User user){
        System.out.println(user);
        userService.update(user);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
        //注解@RequestParam接收的参数是来自requestHeader中，即请求头。
        //@RequestBody接收的参数是来自requestBody中，即请求体，在这里数据是在请求体里 其他的方法都是null
    }

}
