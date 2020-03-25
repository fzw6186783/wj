package com.evan.wj.dao;

import com.evan.wj.bean.AdminRole;
import com.evan.wj.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminUserRoleDao {
    @Insert("insert into admin_user_role(uid,rid) values(#{user.id},#{role.id})")
    public void add(@Param("user") User user,@Param("role")AdminRole role);
   @Delete("delete from admin_user_role where uid=#{user.id} ")
    public void delete(@Param("user") User user);

}
