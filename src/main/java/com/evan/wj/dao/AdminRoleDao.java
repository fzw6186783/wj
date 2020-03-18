package com.evan.wj.dao;

import com.evan.wj.bean.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminRoleDao {
//@Select("select rid from admin_user_role where uid=#{uid}")
//    public List<Integer> findRidByUid();

@Select("select a.id,a.name,a.name_zh`nameZh`,a.enabled from admin_role`a` inner join admin_user_role on a.id=admin_user_role.rid where admin_user_role.uid=#{uid}")
    public List<AdminRole> findById(Integer uid);
}
