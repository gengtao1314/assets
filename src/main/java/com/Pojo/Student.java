package com.Pojo;


import java.util.Date;

public class Student {
    private Long id;

    private Date admissionTime;

    private Date birthday;

    private String name;

    private String employmentId;

    private String major;

    private Boolean beDeleted;

//    接受前端日期数据
    private String myAdmissionTime;

    private String myBirthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Boolean getBeDeleted() {
        return beDeleted;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
    }

    public String getMyAdmissionTime() {
        return myAdmissionTime;
    }

    public void setMyAdmissionTime(String myAdmissionTime) {
        this.myAdmissionTime = myAdmissionTime;
    }

    public String getMyBirthday() {
        return myBirthday;
    }

    public void setMyBirthday(String myBirthday) {
        this.myBirthday = myBirthday;
    }
}