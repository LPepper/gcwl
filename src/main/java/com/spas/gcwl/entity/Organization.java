package com.spas.gcwl.entity;

public class Organization {
    private String name;
    private String phone;
    private String address;
    private Integer id;

    public Organization(String name,String phone,String address){
        this.address=address;
        this.phone=phone;
        this.name=name;
    }

    public Organization(String name, String phone, String address, Integer id) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
