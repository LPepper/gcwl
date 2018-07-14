package com.spas.gcwl.entity;

import java.sql.Date;

public class ECheckInfo {
    private String number;
    private Integer p_number;
    private Float carload;
    private Float height;
    private String box_check;
    private String light_check;
    private String tyre_check;
    private String belt_check;
    private String fire_extinguisher_check;
    private String notice_board_check;
    private String recorder_check;
    private String reflecting_mark_check;
    private String protection_check;
    private String hammer_check;
    private String auto_fire_ex_check;
    private String car_mark_check;
    private String other;
    private String type;
    private Date date;

    public ECheckInfo() {
    }

    public ECheckInfo(String number, Integer p_number, Float carload, Float height, String box_check, String light_check, String tyre_check, String belt_check, String fire_extinguisher_check, String notice_board_check, String recorder_check, String reflecting_mark_check, String protection_check, String hammer_check, String auto_fire_ex_check, String car_mark_check, String other, String type, Date date) {
        this.number = number;
        this.p_number = p_number;
        this.carload = carload;
        this.height = height;
        this.box_check = box_check;
        this.light_check = light_check;
        this.tyre_check = tyre_check;
        this.belt_check = belt_check;
        this.fire_extinguisher_check = fire_extinguisher_check;
        this.notice_board_check = notice_board_check;
        this.recorder_check = recorder_check;
        this.reflecting_mark_check = reflecting_mark_check;
        this.protection_check = protection_check;
        this.hammer_check = hammer_check;
        this.auto_fire_ex_check = auto_fire_ex_check;
        this.car_mark_check = car_mark_check;
        this.other = other;
        this.type = type;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getP_number() {
        return p_number;
    }

    public void setP_number(Integer p_number) {
        this.p_number = p_number;
    }

    public Float getCarload() {
        return carload;
    }

    public void setCarload(Float carload) {
        this.carload = carload;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getBox_check() {
        return box_check;
    }

    public void setBox_check(String box_check) {
        this.box_check = box_check;
    }

    public String getLight_check() {
        return light_check;
    }

    public void setLight_check(String light_check) {
        this.light_check = light_check;
    }

    public String getTyre_check() {
        return tyre_check;
    }

    public void setTyre_check(String tyre_check) {
        this.tyre_check = tyre_check;
    }

    public String getBelt_check() {
        return belt_check;
    }

    public void setBelt_check(String belt_check) {
        this.belt_check = belt_check;
    }

    public String getFire_extinguisher_check() {
        return fire_extinguisher_check;
    }

    public void setFire_extinguisher_check(String fire_extinguisher_check) {
        this.fire_extinguisher_check = fire_extinguisher_check;
    }

    public String getNotice_board_check() {
        return notice_board_check;
    }

    public void setNotice_board_check(String notice_board_check) {
        this.notice_board_check = notice_board_check;
    }

    public String getRecorder_check() {
        return recorder_check;
    }

    public void setRecorder_check(String recorder_check) {
        this.recorder_check = recorder_check;
    }

    public String getReflecting_mark_check() {
        return reflecting_mark_check;
    }

    public void setReflecting_mark_check(String reflecting_mark_check) {
        this.reflecting_mark_check = reflecting_mark_check;
    }

    public String getProtection_check() {
        return protection_check;
    }

    public void setProtection_check(String protection_check) {
        this.protection_check = protection_check;
    }

    public String getHammer_check() {
        return hammer_check;
    }

    public void setHammer_check(String hammer_check) {
        this.hammer_check = hammer_check;
    }

    public String getAuto_fire_ex_check() {
        return auto_fire_ex_check;
    }

    public void setAuto_fire_ex_check(String auto_fire_ex_check) {
        this.auto_fire_ex_check = auto_fire_ex_check;
    }

    public String getCar_mark_check() {
        return car_mark_check;
    }

    public void setCar_mark_check(String car_mark_check) {
        this.car_mark_check = car_mark_check;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
