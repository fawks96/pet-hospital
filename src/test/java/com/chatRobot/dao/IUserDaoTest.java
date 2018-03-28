package com.chatRobot.dao;

/**
 * Created by starr on 2018/3/7.
 */
import com.chatRobot.model.UserInfo;
import com.chatRobot.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private IUserService userService;
    @Test
    public void testSelectCaseByDisease() throws Exception{
        String name="admin";
        String password = "123";
        UserInfo user = userService.checkLogin(name, password);
        System.out.println(user.getPwd());
    }
}
