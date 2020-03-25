package com.evan.wj.service;

import com.evan.wj.bean.AdminPermission;
import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.User;
import com.evan.wj.dao.AdminPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminPermissionService {
    @Autowired
    AdminPermissionDao adminPermissionDao;
    @Autowired
    UserService userService;
    @Autowired
    AdminRoleService adminRoleService;

    public List<AdminPermission> findByRid(Integer rid){
        return adminPermissionDao.findByRid(rid);
    }

    public List<AdminPermission> findAll(){return adminPermissionDao.findAll();}

    public Set<String> listPermissionURLsByUser(String username){
        Set<String> res=new HashSet<>();
        User user=userService.getByName(username);
        List<AdminRole> roles=adminRoleService.findByUid(user.getId());
       for(AdminRole ss:roles){
        for(AdminPermission a:adminPermissionDao.findByRid(ss.getId())){
            res.add(a.getUrl());
        }
       }
        return res;
    }
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDao.findAll();
        for (AdminPermission p: ps) {
            // 这里我们进行前缀匹配，拥有父权限就拥有所有子权限
            if (requestAPI.startsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }

}
