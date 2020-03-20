package com.evan.wj.service;

import com.evan.wj.bean.AdminRole;
import com.evan.wj.dao.AdminRolePermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionDao adminRolePermissionDao;

    public void update(AdminRole role) throws Exception{


            adminRolePermissionDao.delete(role);
        if(role.getPerms()==null||role.getPerms().size()==0){return;}
            adminRolePermissionDao.add(role);

    }
    public void delete(AdminRole role){
        adminRolePermissionDao.delete(role);

    }
}
