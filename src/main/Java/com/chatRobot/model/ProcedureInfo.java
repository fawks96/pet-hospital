package com.chatRobot.model;

import java.io.Serializable;
import java.util.List;

public class ProcedureInfo implements Serializable {
    private Integer id;

    private Integer role_id;

    private Integer step;

    private String info;

    private String procedure_name;

    private List<String> picUrl;

    private List<String> videoUrl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer roleId) {
        this.role_id = roleId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getProcedure_name() {
        return procedure_name;
    }

    public void setProcedure_name(String procedureName) {
        this.procedure_name = procedureName == null ? null : procedureName.trim();
    }

    public List<String> getPicUrl(){return this.picUrl;}

    public void setPicUrl(List<String> picUrl){this.picUrl=picUrl;}

    public List<String> getVideoUrl(){return this.videoUrl;}

    public void setVideoUrl(List<String> videoUrl){this.videoUrl=videoUrl;}
}