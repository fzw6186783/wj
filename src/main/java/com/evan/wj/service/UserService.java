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
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

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
        List<User> users=userdao.findAll();
        for(User a:users){
            a.setRoles(adminRoleService.findByUid(a.getId()));
        }
        return users;
    }
    public void deleteById(Integer id){
        userdao.deleteById(id);
    }
    public void update(User user){

        userdao.update(user);
       adminUserRoleService.update(user);

    }


//    public void add(User user) {
//        userdao.save(user);
//    }
}
