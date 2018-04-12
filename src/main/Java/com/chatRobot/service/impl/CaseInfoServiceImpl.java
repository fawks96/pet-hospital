package com.chatRobot.service.impl;

import com.chatRobot.dao.CaseInfoMapper;
import com.chatRobot.model.CaseDetail;
import com.chatRobot.model.CaseInfo;
import com.chatRobot.model.Stage;
import com.chatRobot.service.CaseInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<Stage> stages=new ArrayList<>();

        for(int i=1;i<=4;i++) {
            Stage stage1=new Stage();

            stage1.setStage(i);

            List<String> picUrl = this.dao.getPicUrl(caseID,i);
            if (!picUrl.isEmpty())
                stage1.setPicURL(picUrl);

            //获取视频
            List<String> videoUrl = this.dao.getVideoUrl(caseID,i);
            if (!videoUrl.isEmpty())
                stage1.setVideoURL(videoUrl);

            //获取text
            List<String> text = this.dao.getText(caseID,i);
            if (!text.isEmpty())
                stage1.setText(text);

            if(!picUrl.isEmpty()||!videoUrl.isEmpty()||!text.isEmpty()){
                if(i==1)
                    stage1.setName("接诊");
                else if(i==2)
                    stage1.setName("病例检查");
                else if(i==3)
                    stage1.setName("诊断结果");
                else if(i==4)
                    stage1.setName("治疗方案");
                stages.add(stage1);
            }
            //stages.add(stage1);
        }
        detail.setStages(stages);

        return detail;
    }
}
