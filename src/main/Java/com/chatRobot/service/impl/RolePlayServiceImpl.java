package com.chatRobot.service.impl;

import com.chatRobot.service.RolePlayService;
import org.springframework.stereotype.Service;
import com.chatRobot.dao.ProcedureInfoMapper;
import com.chatRobot.model.procedureRes;
import com.chatRobot.model.ProcedureInfo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by starr on 2018/3/31.
 */
@Service("RolePlayService")
public class RolePlayServiceImpl implements RolePlayService{
    @Resource
    private ProcedureInfoMapper dao;

    public List<procedureRes> getRoleProcedure(Integer role,String domain) {
        /*List<ProcedureInfo> procedureInfos=dao.getRoleProcedure(role);
        List<procedureRes> procedureRes=new ArrayList<>();
        for(int i=0;i<procedureInfos.size();i++){
            procedureRes procedureRes1=new procedureRes();
            procedureRes1.setRole(procedureInfos.get(i).getRoleId());
            procedureRes1.setStep(procedureInfos.get(i).getStep());
            procedureRes1.setProcedureID(procedureInfos.get(i).getId());
            procedureRes1.setProcedureName(procedureInfos.get(i).getProcedure_name());
            procedureRes.add(procedureRes1);
            System.out.print(procedureInfos.get(i).getProcedure_name());
        }*/
        return dao.getRoleProcedure(role,domain);
    }

    public ProcedureInfo getProcedureDetail(Integer procedureID){
        ProcedureInfo procedureInfo=new ProcedureInfo();

        procedureInfo=dao.getProcedureDetail(procedureID);

        //获取图片
        List<String> picUrl=this.dao.getPicUrl(procedureID);
        if(!picUrl.isEmpty())
            procedureInfo.setPicUrl(picUrl);

        //获取视频
        List<String> videoUrl=this.dao.getVideoUrl(procedureID);
        if(!videoUrl.isEmpty())
            procedureInfo.setVideoUrl(videoUrl);

        return procedureInfo;
    }

    public List<String> getAllDomain(Integer role){return dao.getAllDomain(role);}
}
