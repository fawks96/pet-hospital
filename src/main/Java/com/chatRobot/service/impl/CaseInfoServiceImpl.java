package com.chatRobot.service.impl;

import com.chatRobot.dao.CaseInfoMapper;
import com.chatRobot.model.CaseDetail;
import com.chatRobot.model.CaseInfo;
import com.chatRobot.service.CaseInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * Created by starr on 2018/3/22.
 */
@Service("CaseInfoService")
public class CaseInfoServiceImpl implements CaseInfoService{
    @Resource
    private CaseInfoMapper dao;

    public List<CaseInfo> getCaseByDisease(Integer diseaseID){
        return this.dao.selectByDisease(diseaseID);
    }

    public Integer getDiseaseID(String name){
        return this.dao.getDiseaseID(name);
    }

    public CaseDetail getDetail(Integer caseID){
        CaseDetail detail=new CaseDetail();

        detail.setID(caseID);

        //获取图片
        List<String> picUrl=this.dao.getPicUrl(caseID);
        if(!picUrl.isEmpty())
            detail.setPicUrl(picUrl);

        //获取视频
        List<String> videoUrl=this.dao.getVideoUrl(caseID);
        if(!videoUrl.isEmpty())
            detail.setVideoUrl(videoUrl);

        //获取text
        List<String> text=this.dao.getText(caseID);
        if(!text.isEmpty())
            detail.setText(text);

        return detail;
    }
}
