package com.evan.wj;

import com.evan.wj.bean.*;
import com.evan.wj.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class WjApplicationTests {
@Autowired
UserService userService;
@Autowired
AdminRoleService adminRoleService;
@Autowired
AdminRoleMenuService adminRoleMenuService;
    @Autowired
    AdminPermissionService adminPermissionService;
//    AdminMenuService adminMenuService;
    //AdminPermissionService  adminPermissionService;
    @Test
    void contextLoads() {
User user=new User(30,"1","23","2");

//       List<AdminRole> listrs=new ArrayList<>();
//        AdminRole a=  new AdminRole(1);
//        listrs.add(a);
//        user.setRoles(listrs); userService.update(user);
//        System.out.println(adminPermissionService.listPermissionURLsByUser("admin"));
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> a:map.entrySet()){

        }





    }

}
