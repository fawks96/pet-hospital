package com.chatRobot.dao;

import com.chatRobot.model.DiseaseInfo;
import com.chatRobot.model.DiseaseInfoExample;
import java.util.List;
public interface DiseaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiseaseInfo record);

    int insertSelective(DiseaseInfo record);

    List<DiseaseInfo> selectByExample(DiseaseInfoExample example);

    DiseaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiseaseInfo record);

    int updateByPrimaryKey(DiseaseInfo record);

    List<DiseaseInfo> selectByCategory(String category);

    List<String> getCategory();

    List<DiseaseInfo> getAllCategory();

}