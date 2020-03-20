package com.evan.wj.dao;

import com.evan.wj.bean.AdminRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminRoleDao {
//@Select("select rid from admin_user_role where uid=#{uid}")
//    public List<Integer> findRidByUid();

@Select("select a.id,a.name,a.name_zh`nameZh`,a.enabled from admin_role`a` inner join admin_user_role on a.id=admin_user_role.rid where admin_user_role.uid=#{uid}")
    public List<AdminRole> findById(Integer uid);
    @Select("select a.id,a.name,a.name_zh`nameZh`,a.enabled from admin_role`a`")
    public List<AdminRole> findAll();
@Update("update admin_role set name=#{role.name},name_zh=#{role.nameZh} where id=#{role.id}")
    public void update(@Param("role") AdminRole role);
@Insert("insert into admin_role(name,name_zh) values(#{role.name},#{role.nameZh})")
    public boolean add(@Param("role") AdminRole role);
@Delete("delete from admin_role where id=#{role.id}")
public boolean delete(@Param("role") AdminRole role);
}
