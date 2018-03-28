package com.chatRobot.service.impl;

import com.chatRobot.dao.CaseInfoMapper;
import com.chatRobot.model.CaseInfo;
import java.util.List;
import javax.annotation.Resource;

/**
 * Created by starr on 2018/3/22.
 */
public class CaseInfoServiceImpl {
    @Resource
    private CaseInfoMapper dao;

    public List<CaseInfo> getCaseByDisease(Integer diseaseID){
        return this.dao.selectByDisease(diseaseID);
    }
}
