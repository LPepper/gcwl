package com.spas.gcwl.entity;

public class CarInfo {
    private String number;
    private String type;
    private Float length;
    private Float width;
    private Float height;
    private Float carload;
    private String location;
    private String belong;
    private Float price;
    private Float price_per_day;
    private String state;

    public CarInfo(String number, String type, Float length, Float width, Float height, Float carload, String location, String belong, Float price, Float price_per_day, String state) {
        this.number = number;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.carload = carload;
        this.location = location;
        this.belong = belong;
        this.price = price;
        this.price_per_day = price_per_day;
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getCarload() {
        return carload;
    }

    public void setCarload(Float carload) {
        this.carload = carload;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(Float price_per_day) {
        this.price_per_day = price_per_day;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
