package com.evan.wj.service;

import com.evan.wj.bean.AdminPermission;
import com.evan.wj.dao.AdminPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPermissionService {
    @Autowired
    AdminPermissionDao adminPermissionDao;

    public List<AdminPermission> findByRid(Integer rid){
        return adminPermissionDao.findByRid(rid);
    }

    public List<AdminPermission> findAll(){return adminPermissionDao.findAll();}

}
