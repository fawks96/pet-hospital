package com.chatRobot.model;

import java.util.List;

/**
 * Created by starr on 2018/3/31.
 */
public class procedureList {
    private String label;
    private List<procedureRes> children;

    public String getLabel(){return this.label;}

    public void setLabel(String label){this.label=label;}

    public List<procedureRes> getChildren(){return this.children;}

    public void setChildren(List<procedureRes> procedureRes){this.children=procedureRes;}
}
