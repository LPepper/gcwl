package com.spas.gcwl.entity;

public class User {
    private String username;
    private String password;
    private String phone;
    private String organization;


    public User(String username,String password,String phone,String organization){
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.organization=organization;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPhone() {
        return phone;
    }
}
