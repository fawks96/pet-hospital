package com.chatRobot.service.impl;

import com.chatRobot.dao.QuestionInfoMapper;
import com.chatRobot.dao.UserInfoMapper;
import com.chatRobot.model.QuestionInfo;
import com.chatRobot.model.RecordInfo;
import com.chatRobot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Resource
    //@Autowired
    private QuestionInfoMapper questionDao;

    public List<QuestionInfo> getByCategory(String category)
    {
        List<QuestionInfo> resList = this.questionDao.getByCategory(category);
        return resList;
    }

    public List<QuestionInfo> getByList(List<String> list)
    {
        List<QuestionInfo> resList = this.questionDao.getByList(list);
        return resList;
    }

    public String getAnsById(Integer ques_id)
    {
        System.out.println("service:"+ques_id);
        return this.questionDao.getAnsById(ques_id);
    }

    @Override
    public QuestionInfo getById(Integer id) {
        return questionDao.getById(id);
    }
}
