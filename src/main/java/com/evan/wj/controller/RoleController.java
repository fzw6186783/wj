package com.evan.wj.controller;

import com.evan.wj.bean.AdminMenu;
import com.evan.wj.bean.AdminPermission;
import com.evan.wj.bean.AdminRole;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.AdminMenuService;
import com.evan.wj.service.AdminPermissionService;
import com.evan.wj.service.AdminRoleMenuService;
import com.evan.wj.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RoleController {
    @Autowired
    AdminRoleService adminRoleService;
  @Autowired
  AdminPermissionService adminPermissionService;
  @Autowired
    AdminMenuService adminMenuService;
  @Autowired
  AdminRoleMenuService adminRoleMenuService;

    @GetMapping("/api/admin/role")
    public List<AdminRole> listRoles(){
        //return adminRoleService.findByUid();
       // return adminRoleService.findAllPlus();
        return adminRoleService.findAllPlus();
    }
    @GetMapping("/api/admin/role/perm")
    public List<AdminPermission> listRolesPerm(){
        //return adminRoleService.findByUid();
        return adminPermissionService.findAll();
    }

    @PutMapping("/api/admin/role")
    public Result updateRole(@RequestBody AdminRole requestRole){
       // System.out.println(requestRole);
       if( adminRoleService.update(requestRole) ){
           return ResultFactory.buildSuccessResult("修改用户成功");
       }
       else {
           return ResultFactory.buildFailResult("参数错误，修改失败");
       }

    }
    @PutMapping("/api/admin/role/menu")
    public Result updateRoleMenu(@RequestParam int rid, @RequestBody LinkedHashMap menusIds) {
       // System.out.println(rid); System.out.println(menusIds);


       if(adminRoleMenuService.update(rid, menusIds)) {
            return ResultFactory.buildSuccessResult("更新成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，更新失败");
        }

    }
    @PostMapping("/api/admin/role")
    public Result addRole(@RequestBody AdminRole requestRole) {
        if (adminRoleService.add(requestRole)) {
            return ResultFactory.buildSuccessResult("修改用户成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，修改失败");
        }
    }

    @PutMapping("/api/admin/role/delete")
    public Result deleteRole(@RequestBody AdminRole requestRole) {

        if (adminRoleService.delete(requestRole)) {
            return ResultFactory.buildSuccessResult("删除用户成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，修改失败");
        }
    }



}
