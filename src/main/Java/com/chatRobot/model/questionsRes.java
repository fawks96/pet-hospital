package com.chatRobot.model;

import java.util.*;
import com.chatRobot.model.QuestionInfo;
public class questionsRes {

    private String status;

    private List<QuestionInfo> questionList;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public List<QuestionInfo> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionInfo> questionList) {
        this.questionList = questionList;
    }

}
