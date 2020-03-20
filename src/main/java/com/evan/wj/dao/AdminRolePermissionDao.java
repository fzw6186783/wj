package com.evan.wj.dao;

import com.evan.wj.bean.AdminRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;



@Mapper
@Component
public interface AdminRolePermissionDao {
@Delete("delete from admin_role_permission where rid=#{role.id}")
    public void delete(@Param("role") AdminRole role);
@Insert("<script>insert into admin_role_permission(rid,pid)values <foreach collection='role.perms' item='perm' separator=','>(#{role.id},#{perm.id})</foreach></script>")
    public void add(@Param("role") AdminRole role);

}
