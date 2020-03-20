package com.evan.wj.service;


import com.evan.wj.bean.AdminMenu;
import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.User;
import com.evan.wj.dao.AdminRoleDao;
import org.apache.ibatis.annotations.Param;
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
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
@Autowired
AdminRoleMenuService adminRoleMenuService;
    public List<AdminRole> findByUid(Integer id){

        List<AdminRole> a=adminRoleDao.findById(id);
        for(AdminRole b:a){
            b.setPerms(adminPermissionService.findByRid(b.getId()));
            b.setMenus(adminMenuService.findByRid(b.getId()));
        }

        return a;
    }
    public List<AdminRole> findAll(){
        return adminRoleDao.findAll();
    }


    public List<AdminRole> findAllPlus(){
        List<AdminRole> a=adminRoleDao.findAll();
        for(AdminRole b:a){
            b.setPerms(adminPermissionService.findByRid(b.getId()));
            b.setMenus(adminMenuService.findByRid(b.getId()));//这里有问题
        }

        return a;

    }
    public boolean update( AdminRole role){
        try {
            adminRoleDao.update(role);
            adminRolePermissionService.update(role);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean add(@Param("role") AdminRole role){


        try {
            adminRoleDao.add(role);
        } catch (Exception e) {
            e.printStackTrace();
            return false;//这么些 finally不能加return  会死掉的
        }
        return true;


    }
    public boolean delete(@Param("role") AdminRole role){

        try {
          //  adminRoleMenuService.delete(role.getId());
            adminRolePermissionService.delete(role);
            adminRoleDao.delete(role);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
