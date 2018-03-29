package com.chatRobot.service;
import com.chatRobot.model.QuestionInfo;
import java.util.*;

public interface TestService {

    public List<QuestionInfo> getByCategory(String category);
}
