package com.evan.wj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




//@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class User {
    Integer id;
    String username;
    String password;
    String salt;
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    User(){

    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

