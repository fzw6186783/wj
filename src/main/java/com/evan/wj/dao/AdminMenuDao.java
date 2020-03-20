package com.evan.wj.dao;

import com.evan.wj.bean.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminMenuDao {


        @Select("select a.id`id`,a.path`path`,a.name`name`,a.name_zh`nameZh`,a.icon_cls`iconCls`,a.component`component`,a.parent_id`parentId` from admin_menu`a` inner join admin_role_menu`b` on a.id=b.mid\n" +
                "where b.rid=#{rid}")
        public List<AdminMenu> findByRid(Integer rid);
        @Select("select a.id`id`,a.path`path`,a.name`name`,a.name_zh`nameZh`,a.icon_cls`iconCls`,a.component`component`,a.parent_id`parentId` from admin_menu`a`")
        public List<AdminMenu> findAll();

    }

