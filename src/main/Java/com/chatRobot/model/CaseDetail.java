package com.chatRobot.model;

import java.util.List;

/**
 * Created by starr on 2018/3/28.
 */
public class CaseDetail {
    private Integer ID;
    private List<Stage> stages;
    //private List<String> picUrl;
    //private List<String> videoUrl;
    //private List<String> text;
    //private String stage;

    public Integer getID(){return ID;}

    public void setID(Integer ID){
        System.out.println(ID);
        this.ID=ID;
    }

    public List<Stage> getStages(){return stages;}

    public void setStages(List<Stage> stages){this.stages=stages;}

    /*
    public List<String> getPicUrl(){return picUrl;}

    public void setPicUrl(List<String> picUrls){this.picUrl=picUrls;}

    public void addPicUrl(String picUrl){this.picUrl.add(picUrl);}

    public  List<String> getVideoUrl(){return videoUrl;}

    public void setVideoUrl(List<String> videoUrls){this.videoUrl=videoUrls;}

    public void addVideoUrl(String videoUrl){this.videoUrl.add(videoUrl);}

    public List<String> getText(){return text;}

    public  void setText(List<String> texts){this.text=texts;}

    public void addText(String text){this.text.add(text);}
    */
}
