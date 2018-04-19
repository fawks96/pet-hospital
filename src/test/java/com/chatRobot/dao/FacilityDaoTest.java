package com.chatRobot.dao;


import com.chatRobot.model.FacilityInfo;
import com.chatRobot.service.FacilityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class FacilityDaoTest {


    @Autowired
    private FacilityService facilityService;

    @Test
    public void testdao() throws Exception
    {
        FacilityInfo res = facilityService.getById(14);
        System.out.println(res.getInfo() + " " + res.getPicture());
    }

}
