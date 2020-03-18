package com.evan.wj.service;

import com.evan.wj.dao.UserDao;
import com.evan.wj.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userdao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userdao.findByUsername(username);
    }

    public User get(String username, String password){
        return userdao.getByUsernameAndPassword(username, password);
    }
    public void add(User user){
        userdao.add(user);
    }
    public List<User> findAll(){
        return userdao.findAll();
    }



//    public void add(User user) {
//        userdao.save(user);
//    }
}
