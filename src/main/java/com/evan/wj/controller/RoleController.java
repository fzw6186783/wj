package com.evan.wj.controller;

import com.evan.wj.bean.AdminRole;
import com.evan.wj.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    AdminRoleService adminRoleService;


    @GetMapping("/api/admin/role")
    public List<AdminRole> listRoles(){
        return adminRoleService.findByUid();
    }
}
