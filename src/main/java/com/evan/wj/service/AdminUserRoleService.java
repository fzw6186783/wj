package com.evan.wj.service;

import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.User;
import com.evan.wj.dao.AdminUserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleDao adminUserRoleDao;

    public void update(User user){
        adminUserRoleDao.delete(user);
        for(AdminRole role:user.getRoles()){
            adminUserRoleDao.add(user,role);
        }

    }
}
