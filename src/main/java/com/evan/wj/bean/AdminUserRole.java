package com.evan.wj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * Relations between users and role.
 *
 * @author Evan
 * @date 2019/11
 */

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminUserRole {

    private int id;

    /**
     * User id.
     */
    private int uid;

    /**
     * Role id.
     */
    private int rid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
