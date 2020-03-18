package com.evan.wj.dao;

import com.evan.wj.bean.AdminPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface AdminPermissionDao {

@Select("select a.id`id`,a.name`name`,a.desc_`desc_`,a.url`url` from admin_permission`a` inner join admin_role_permission`b` " +
        "on a.id=b.pid" +
        " where b.rid=#{rid}")
    public List<AdminPermission> findByRid(@Param("rid") Integer rid);
}
