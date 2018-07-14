package com.spas.gcwl.entity;

import javax.validation.groups.Default;
import java.util.Set;

public class Role {
    private Integer id;
    private String role_name;
    private String role_description;

    private Set<String> authorities;
    private String authorityName;

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Role(){

    }

    public Role(Integer id, String role_name, String role_description) {
        this.id = id;
        this.role_name = role_name;
        this.role_description = role_description;
    }



    public  Role(String role_name, String role_description) {
        this.role_name = role_name;
        this.role_description = role_description;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
