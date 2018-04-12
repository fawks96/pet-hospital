package com.chatRobot.dao;

/**
 * Created by starr on 2018/3/7.
 */
import com.chatRobot.model.*;
import com.chatRobot.service.CaseInfoService;
import com.chatRobot.service.DiseaseInfoService;
import com.chatRobot.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testLogin() throws Exception{
        String name="admin";
        String password = "123";
        UserInfo user = userService.checkLogin(name, password);
        System.out.println(user.getPwd());
    }

    @Test
    public void testRegister() throws Exception{
        if(userService.selectByName("zhang")!=null){
            System.out.println("chongfu");
        }
        else {
            UserInfo user = new UserInfo();
            user.setName("zhang");
            user.setPwd("123");
            user.setAuth(1);
            userService.addUser(user);
        }
    }

    @Test
    public void testSelectByName() throws Exception{
        List<UserInfo> userInfo=userService.selectByName("zhang");
        System.out.println(userInfo.size());
    }
}
