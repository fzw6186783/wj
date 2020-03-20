package com.evan.wj.service;

import com.evan.wj.bean.AdminMenu;
import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.User;
import com.evan.wj.dao.AdminMenuDao;
import com.evan.wj.dao.AdminRoleDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminMenuService {
    @Autowired
    AdminMenuDao adminMenuDao;
    @Autowired
    UserService userService;
    @Autowired
    AdminRoleDao adminRoleDao;

    public List<AdminMenu> findByRid(Integer rid) {
        List<AdminMenu> menus = adminMenuDao.findByRid(rid);
        HashMap<Integer, AdminMenu> map = new HashMap<Integer, AdminMenu>();
        for (AdminMenu menu : menus) {
             menu.setChildren(new ArrayList<AdminMenu>());
            map.put(menu.getId(), menu);
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (map.containsKey(menu.getParentId())) {//有爹
                AdminMenu die = map.get(menu.getParentId());
                if (die.getChildren() == null) {
                    die.setChildren(new ArrayList<AdminMenu>() {{
                        this.add(menu);
                    }});
                } else {
                    die.getChildren().add(menu);
                }
                iterator.remove();
            }

        }
        return menus;
    }
    public List<AdminMenu> findByRid2(Integer rid) {
        return adminMenuDao.findByRid(rid);
    }
    public List<AdminMenu> findByUser() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByName(username);
        List<AdminRole> a=adminRoleDao.findById(user.getId());
        List<AdminMenu> menus=new ArrayList<AdminMenu>();
        for(AdminRole b:a){

            menus.addAll(adminMenuDao.findByRid(b.getId()));
        }
        menus=quchong(menus);

        //装载
        HashMap<Integer, AdminMenu> map = new HashMap<Integer, AdminMenu>();
        for (AdminMenu menu : menus) {
            menu.setChildren(new ArrayList<AdminMenu>());
            map.put(menu.getId(), menu);
        }
        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (map.containsKey(menu.getParentId())) {//有爹
                AdminMenu die = map.get(menu.getParentId());
                if (die.getChildren() == null) {
                    die.setChildren(new ArrayList<AdminMenu>() {{
                        this.add(menu);
                    }});
                } else {
                    die.getChildren().add(menu);
                }
                iterator.remove();
            }
        }
        return menus;
    }

    public List<AdminMenu> quchong(List<AdminMenu> menus) {
        HashSet<Integer> map = new HashSet<Integer>();
        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (map.contains(menu.getId())) {//有爹
                iterator.remove();
            }
            else{map.add(menu.getId());}
        }
        return menus;
    }
    public List<AdminMenu> findAll(){
        List<AdminMenu> menus = adminMenuDao.findAll();
        HashMap<Integer, AdminMenu> map = new HashMap<Integer, AdminMenu>();
        for (AdminMenu menu : menus) {
            menu.setChildren(new ArrayList<AdminMenu>());
            map.put(menu.getId(), menu);
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (map.containsKey(menu.getParentId())) {//有爹
                AdminMenu die = map.get(menu.getParentId());
                if (die.getChildren() == null) {
                    die.setChildren(new ArrayList<AdminMenu>() {{
                        this.add(menu);
                    }});
                } else {
                    die.getChildren().add(menu);
                }
                iterator.remove();
            }
        }
        return menus;
    }
}

