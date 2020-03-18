package com.evan.wj.controller;

import com.evan.wj.bean.AdminMenu;
import com.evan.wj.bean.AdminRole;
import com.evan.wj.service.AdminMenuService;
import com.evan.wj.service.AdminRoleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
@Autowired
AdminMenuService adminMenuService;
    @ResponseBody//在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {

        List<AdminMenu> res=new ArrayList<AdminMenu>();
        res=adminMenuService.findByUser();
        return res;
    }

    @GetMapping("/api/admin/role/menu")
    public List<AdminMenu> listAllMenus() {
        return adminMenuService.findByRid(1);
    }

}
