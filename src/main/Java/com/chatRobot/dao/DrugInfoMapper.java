package com.chatRobot.dao;

import com.chatRobot.model.DrugInfo;
import com.chatRobot.model.DrugInfoExample;
import com.chatRobot.model.FacilityInfo;

import java.util.List;

public interface DrugInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DrugInfo record);

    int insertSelective(DrugInfo record);

    List<DrugInfo> selectByExample(DrugInfoExample example);

    DrugInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DrugInfo record);

    int updateByPrimaryKey(DrugInfo record);

    DrugInfo getById(Integer id);

}