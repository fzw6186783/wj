package com.evan.wj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

/**
 * Role entity.
 *
 * @author Evan
 * @date 2019/11
 */

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRole {

    private int id;

    /**
     * Role name.
     */
    private String name;

    /**
     * Role name in Chinese.
     */

    private String nameZh;

    /**
     * Role status.
     */
    private boolean enabled;

    /**
     * Transient property for storing permissions owned by current role.
     */

    private List<AdminPermission> perms;

    /**
     * Transient property for storing menus owned by current role.
     */

    private List<AdminMenu> menus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AdminPermission> getPerms() {
        return perms;
    }

    public void setPerms(List<AdminPermission> perms) {
        this.perms = perms;
    }

    public List<AdminMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<AdminMenu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", enabled=" + enabled +
                ", perms=" + perms +
                ", menus=" + menus +
                '}';
    }
}
