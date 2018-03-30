package com.chatRobot.dao;

import com.chatRobot.model.RecordInfo;
import com.chatRobot.model.RecordInfoExample;
import com.chatRobot.model.RecordInfoKey;
import java.util.List;

public interface RecordInfoMapper {
    int deleteByPrimaryKey(RecordInfoKey key);

    int insert(RecordInfo record);

    int insertSelective(RecordInfo record);

    List<RecordInfo> selectByExample(RecordInfoExample example);

    RecordInfo selectByPrimaryKey(RecordInfoKey key);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);

    public void addRecord(RecordInfo recordInfo);
}