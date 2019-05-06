package com.Pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/9.
 */
@Component
public class User {
    private int id;
    private String username;
    private String password;
    private Date createtime;

    private String myCreateTime;

    public String getMyCreateTime() {
        return myCreateTime;
    }

    public void setMyCreateTime(String myCreateTime) {
        this.myCreateTime = myCreateTime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    private String name;     //用户名称
    private Integer state;   //用户状态


    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
