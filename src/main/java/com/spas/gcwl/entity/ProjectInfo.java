package com.spas.gcwl.entity;

import java.sql.Date;
public class ProjectInfo {
    private Integer project_id;
    private String userme;
    private String name;
    private Date bdate;
    private Date edate;
    private Float offer;
    private String state;
    private String blocation;
    private String elocation;
    private String goods_info;
    private String handler_username;
    private String phone;

    public ProjectInfo(String userme, String name, Date bdate, Date edate, String state, String blocation, String elocation, String goods_info, String phone) {
        this.userme = userme;
        this.name = name;
        this.bdate = bdate;
        this.edate = edate;
        this.state = state;
        this.blocation = blocation;
        this.elocation = elocation;
        this.goods_info = goods_info;
        this.phone = phone;
    }

    public ProjectInfo(Integer project_id, Float offer, String state, String handler_username) {
        this.project_id = project_id;
        this.offer = offer;
        this.state = state;
        this.handler_username = handler_username;
    }

    public ProjectInfo(Integer project_id, String userme, String name, Date bdate, Date edate, Float offer, String state, String blocation, String elocation, String goods_info, String handler_username, String phone) {
        this.project_id = project_id;
        this.userme = userme;
        this.name = name;
        this.bdate = bdate;
        this.edate = edate;
        this.offer = offer;
        this.state = state;
        this.blocation = blocation;
        this.elocation = elocation;
        this.goods_info = goods_info;
        this.handler_username = handler_username;
        this.phone = phone;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getUserme() {
        return userme;
    }

    public void setUserme(String userme) {
        this.userme = userme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Float getOffer() {
        return offer;
    }

    public void setOffer(Float offer) {
        this.offer = offer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBlocation() {
        return blocation;
    }

    public void setBlocation(String blocation) {
        this.blocation = blocation;
    }

    public String getElocation() {
        return elocation;
    }

    public void setElocation(String elocation) {
        this.elocation = elocation;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    public String getHandler_username() {
        return handler_username;
    }

    public void setHandler_username(String handler_username) {
        this.handler_username = handler_username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
