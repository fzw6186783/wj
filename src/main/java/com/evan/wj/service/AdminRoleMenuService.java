package com.evan.wj.service;

import com.evan.wj.bean.AdminRole;
import com.evan.wj.dao.AdminRoleMenuDao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.*;

@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDao adminRoleMenuDao;

    public void delete( Integer id){
      adminRoleMenuDao.delete(id);
    }
    public void add(int id,List<Integer> list){
        if((list==null||list.size()==0)){return;}
        adminRoleMenuDao.add(id,list);
    }

    public boolean update(int rid, LinkedHashMap linkedHashMap){
//        for (Object value : linkedHashMap.values()) {
//            for (int mid : (List<Integer>) value) {
//                System.out.println(mid);
//            }}
        try {
            delete(rid);
            for (Object value : linkedHashMap.values()) {
                    adminRoleMenuDao.add(rid,(List<Integer>)value);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }




}
