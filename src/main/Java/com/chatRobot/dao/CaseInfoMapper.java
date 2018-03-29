package com.chatRobot.dao;

import com.chatRobot.model.CaseInfo;
import com.chatRobot.model.CaseInfoExample;
import java.util.List;

public interface CaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseInfo record);

    int insertSelective(CaseInfo record);

    List<CaseInfo> selectByExample(CaseInfoExample example);

    CaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseInfo record);

    int updateByPrimaryKey(CaseInfo record);

    List<CaseInfo> selectByDisease(Integer diseaseID);

    Integer getDiseaseID(String name);

    List<String> getPicUrl(Integer caseID);

    List<String> getVideoUrl(Integer caseID);

    List<String> getText(Integer caseID);
}