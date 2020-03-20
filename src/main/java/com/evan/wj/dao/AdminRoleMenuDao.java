package com.evan.wj.dao;

import com.evan.wj.bean.AdminMenu;
import com.evan.wj.bean.AdminRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface AdminRoleMenuDao {

    @Delete("delete from admin_role_menu where rid=#{role}")
    public void delete(@Param("role")Integer id);
    @Insert("<script>insert into admin_role_menu(rid,mid) values <foreach collection='list' item='menu' separator=','>(#{role},#{menu})</foreach></script>")
    public void add(@Param("role") Integer id, @Param("list") List<Integer> list);
}
