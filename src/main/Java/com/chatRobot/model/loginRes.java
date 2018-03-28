package com.chatRobot.model;

/**
 * Created by starr on 2018/3/27.
 */
public class loginRes {

    private String status;
    private UserInfo user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}