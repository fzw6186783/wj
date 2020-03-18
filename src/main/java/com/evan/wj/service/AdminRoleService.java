package com.evan.wj.service;


import com.evan.wj.bean.AdminMenu;
import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.User;
import com.evan.wj.dao.AdminRoleDao;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDao adminRoleDao;
   @Autowired
   AdminPermissionService adminPermissionService;
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    UserService userService;
    public List<AdminRole> findByUid(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByName(username);
        List<AdminRole> a=adminRoleDao.findById(user.getId());
        for(AdminRole b:a){
            b.setPerms(adminPermissionService.findByRid(b.getId()));
            b.setMenus(adminMenuService.findByRid(b.getId()));
        }

        return a;
    }




}
