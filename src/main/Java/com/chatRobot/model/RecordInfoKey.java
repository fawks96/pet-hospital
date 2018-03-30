package com.chatRobot.model;

import java.io.Serializable;

public class RecordInfoKey implements Serializable {
    private Integer ques_id;

    private Integer user_id;

    private static final long serialVersionUID = 1L;

    public void setQues_id(Integer ques_id) {
        this.ques_id = ques_id;
    }

    public Integer getQues_id() {
        return ques_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }
}