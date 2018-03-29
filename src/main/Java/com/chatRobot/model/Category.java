package com.chatRobot.model;

import java.util.List;

/**
 * Created by starr on 2018/3/29.
 */
public class Category {
    private String lable;
    private List<DiseaseInfo> children;
    //private List<DiseaseInfo> diseaseInfoList;

    public String getLable(){return this.lable;}

    public void setLable(String name){this.lable=name;}

    public List<DiseaseInfo> getChildren(){return this.children;}

    public void setChildren(List<DiseaseInfo> diseaseInfoList){this.children= diseaseInfoList;}
}
