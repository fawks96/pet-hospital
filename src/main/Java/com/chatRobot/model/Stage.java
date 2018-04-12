package com.chatRobot.model;

import java.util.List;
/**
 * Created by starr on 2018/4/12.
 */
public class Stage {
    private int stage;

    private String name;

    private List<String> picURL;

    private List<String> videoURL;

    private List<String> text;

    public String getName(){return this.name;}

    public void setName(String name){this.name=name;}

    public int getStage(){return stage;}

    public void setStage(Integer stage){this.stage=stage;}

    public List<String> getPicURL(){return this.picURL;}

    public void setPicURL(List<String> picurl){this.picURL=picurl;}

    public List<String> getVideoURL(){return this.videoURL;}

    public void setVideoURL(List<String> videourl){this.videoURL=videourl;}

    public List<String> getText(){return this.text;}

    public void setText(List<String> text){this.text=text;}
}
