package com.chatRobot.dao;

import com.chatRobot.model.DepartmentInfo;
import com.chatRobot.model.DepartmentInfoExample;

import java.util.List;

public interface DepartmentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentInfo record);

    int insertSelective(DepartmentInfo record);

    List<DepartmentInfo> selectByExample(DepartmentInfoExample example);

    DepartmentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepartmentInfo record);

    int updateByPrimaryKey(DepartmentInfo record);

    List<DepartmentInfo> selectAll();

}