package com.spas.gcwl.entity;

public class RoleAuthority {
    private Integer id;
    private Integer Role_id;

    public RoleAuthority(Integer id, Integer role_id) {
        this.id = id;
        Role_id = role_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return Role_id;
    }

    public void setRole_id(Integer role_id) {
        Role_id = role_id;
    }
}
