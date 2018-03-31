package com.chatRobot.dao;

import com.chatRobot.model.FacilityInfo;
import com.chatRobot.model.FacilityInfoExample;
import java.util.List;

public interface FacilityInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FacilityInfo record);

    int insertSelective(FacilityInfo record);

    List<FacilityInfo> selectByExample(FacilityInfoExample example);

    FacilityInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FacilityInfo record);

    int updateByPrimaryKey(FacilityInfo record);

    List<FacilityInfo> selectAll();
}