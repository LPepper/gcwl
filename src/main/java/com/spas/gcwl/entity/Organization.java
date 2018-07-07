package com.spas.gcwl.entity;

public class Organization {
    private String name;
    private String phone;
    private String address;

    public Organization(String name,String phone,String address){
        this.address=address;
        this.phone=phone;
        this.name=name;
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
