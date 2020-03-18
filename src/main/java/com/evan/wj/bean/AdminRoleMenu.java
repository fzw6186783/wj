package com.evan.wj.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Relations between roles and menus.
 *
 * @author Evan
 * @date 2019/11
 */

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRoleMenu {

    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Menu id.
     */
    private int mid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
