package com.evan.wj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Menu entity
 *
 * @author Evan
 * @date 2019/11
 */


@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    private int id;
  int c;
    /**
     * Menu access path.
     */
    private String path;

    /**
     * Menu name.
     */
    private String name;

    /**
     * Menu name in Chinese.
     */
    private String nameZh;

    /**
     * Menu icon class(use element-ui icons).
     */
    private String iconCls;

    /**
     * Front-end component name corresponding to menu.
     */
    private String component;

    /**
     * Parent menu.
     */
    private int parentId;

    /**
     * Transient property for storing children menus.
     */

    private List<AdminMenu> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public List<AdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<AdminMenu> children) {
        this.children = children;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "AdminMenu{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", component='" + component + '\'' +
                ", parentId=" + parentId +
                "------------, children=" + children +"----------"+
                '}';
    }
}
