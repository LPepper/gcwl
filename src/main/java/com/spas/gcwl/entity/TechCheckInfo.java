package com.spas.gcwl.entity;


import java.sql.Date;

public class TechCheckInfo {

    private String number;
    private String steer_check;
    private String transmission_check;
    private String brake_check;
    private String dash_board_check;
    private String other;
    private Date date;
    private String type;

    public TechCheckInfo(String number, String steer_check, String transmission_check, String brake_check, String dash_board_check, String other, Date date, String type) {
        this.number = number;
        this.steer_check = steer_check;
        this.transmission_check = transmission_check;
        this.brake_check = brake_check;
        this.dash_board_check = dash_board_check;
        this.other = other;
        this.date = date;
        this.type = type;
    }

    public TechCheckInfo() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSteer_check() {
        return steer_check;
    }

    public void setSteer_check(String steet_check) {
        this.steer_check = steet_check;
    }

    public String getTransmission_check() {
        return transmission_check;
    }

    public void setTransmission_check(String transmission_check) {
        this.transmission_check = transmission_check;
    }

    public String getBrake_check() {
        return brake_check;
    }

    public void setBrake_check(String brake_check) {
        this.brake_check = brake_check;
    }

    public String getDash_board_check() {
        return dash_board_check;
    }

    public void setDash_board_check(String dash_board_check) {
        this.dash_board_check = dash_board_check;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
