package com.chatRobot.dao;

import com.chatRobot.model.QuestionInfo;
import com.chatRobot.model.QuestionInfoExample;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionInfo record);

    int insertSelective(QuestionInfo record);

    List<QuestionInfo> selectByExample(QuestionInfoExample example);

    QuestionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionInfo record);

    int updateByPrimaryKey(QuestionInfo record);

    List<QuestionInfo> getByCategory(String category);

    List<QuestionInfo> getByList(List<String> list);

    String getAnsById(Integer ques_id);

    QuestionInfo getById(Integer id);
}