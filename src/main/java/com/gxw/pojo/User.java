package com.gxw.pojo;

import java.io.Serializable;

/**
 * 用户实体类
 * @author GXW工作室
 * @date 2020/6/10 0010 - 00:53
 */
public class User implements Serializable{
    private Integer uid;
    private String username;
    private String password;
    private Double money;

    public User() {
    }

    public User(Integer uid, String username, String password, Double money) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
