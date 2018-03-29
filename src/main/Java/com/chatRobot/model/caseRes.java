package com.chatRobot.model;

import java.util.List;
/**
 * Created by starr on 2018/3/29.
 */
public class caseRes {
    private List<CaseInfo> caseInfoList;
    private int count;

    public List<CaseInfo> getCaseInfoList(){return this.caseInfoList;}

    public void setCaseInfoList(List<CaseInfo> caseInfoList){this.caseInfoList=caseInfoList;}

    public int getCount(){return this.count;}

    public void setCount(int count){this.count=count;}
}
