package com.chatRobot.service;
import com.chatRobot.model.QuestionInfo;
import com.chatRobot.model.RecordInfo;

import java.util.*;

public interface TestService {

    public List<QuestionInfo> getByCategory(String category);

    public List<QuestionInfo> getByList(List<String> list);

    public String getAnsById(Integer ques_id);

    public QuestionInfo getById(Integer id);
}
