package com.chatRobot.dao;

import com.chatRobot.model.QuestionInfo;
import com.chatRobot.model.UserInfo;
import com.chatRobot.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by starr on 2018/3/29.
 */
public class QuestionDaoTest {
    @Autowired
    private TestService testService;

    @Test
    public void testGetQuestionByCategory() throws Exception{
        String category="炎症";
        List<QuestionInfo> questionInfoList=testService.getByCategory(category);
        System.out.println(questionInfoList.size());
        if(questionInfoList.size()>0){
            for(int i=0;i<questionInfoList.size();i++){
                System.out.println(questionInfoList.get(i).getId());
            }
        }
    }
}
