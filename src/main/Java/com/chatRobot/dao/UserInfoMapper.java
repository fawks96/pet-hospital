package com.chatRobot.dao;

import com.chatRobot.model.UserInfo;
import com.chatRobot.model.UserInfoExample;
import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    public UserInfo findUserByName(String username);

    //public UserInfo adduser(UserInfo user);

}