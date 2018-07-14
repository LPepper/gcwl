package com.spas.gcwl.entity;

public class ProjectACar {
    private  Integer id;
    private  String number;
    private  Integer project_id;

    public ProjectACar(String number, Integer project_id) {
        this.number = number;
        this.project_id = project_id;
    }

    public ProjectACar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }
}
