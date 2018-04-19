package com.chatRobot.dao;

import com.chatRobot.model.FacilityInfo;
import com.chatRobot.service.CaseInfoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.chatRobot.service.DepartmentService;
import java.util.*;
import org.junit.Test;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class DepartmentDaoTest {


        @Autowired
        private DepartmentService departmentService;

        @Test
        public void testdao() throws Exception
        {
           List<Integer> res = departmentService.getFacilityIds(1);
           for (int i = 0; i < res.size(); i++)
           {
               System.out.println(res.get(i));
           }
        }


}
