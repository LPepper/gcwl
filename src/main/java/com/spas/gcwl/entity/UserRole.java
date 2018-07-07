package com.spas.gcwl.entity;

public class UserRole {
    private String userme;
    private Integer id;

    public UserRole(String userme, Integer id) {
        this.userme = userme;
        this.id = id;
    }

    public String getUserme() {
        return userme;
    }

    public void setUserme(String userme) {
        this.userme = userme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
