package com.spas.gcwl.entity;

public class Authority {
    private Integer id;
    private String Authority_tag;

    public Authority(Integer id, String authority_tag) {
        this.id = id;
        Authority_tag = authority_tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority_tag() {
        return Authority_tag;
    }

    public void setAuthority_tag(String authority_tag) {
        Authority_tag = authority_tag;
    }

    //moidfic
}
