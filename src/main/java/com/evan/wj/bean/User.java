package com.evan.wj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


//@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class User {
    Integer id;
    String username;
    String password;
    String salt;
    private String name;private String phone;
    private String email; private boolean enabled;
    private List<AdminRole> roles;
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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<AdminRole> getRoles() {
        return roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setRoles(List<AdminRole> roles) {
        this.roles = roles;
    }
}

