package com.chatRobot.dao;

import com.chatRobot.model.ProcedureInfo;
import com.chatRobot.model.ProcedureInfoExample;
import com.chatRobot.model.procedureRes;
import java.util.List;

public interface ProcedureInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcedureInfo record);

    int insertSelective(ProcedureInfo record);

    List<ProcedureInfo> selectByExample(ProcedureInfoExample example);

    ProcedureInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcedureInfo record);

    int updateByPrimaryKey(ProcedureInfo record);

    List<procedureRes> getRoleProcedure(int role);

    ProcedureInfo getProcedureDetail(int procedureID);

    List<String> getPicUrl(Integer caseID);

    List<String> getVideoUrl(Integer caseID);
}