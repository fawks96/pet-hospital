package com.chatRobot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import com.chatRobot.service.RolePlayService;
import com.chatRobot.model.ProcedureInfo;
import com.chatRobot.model.procedureRes;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by starr on 2018/3/31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class RolePlayTest {
    @Autowired
    private RolePlayService rolePlayService;

    @Test
    public void getRoleProcedureTest() throws Exception{
        Integer role=1;
        List<procedureRes> procedureRes=rolePlayService.getRoleProcedure(role);
        System.out.println(procedureRes.size());
        for(int i=0;i<procedureRes.size();i++){
            System.out.println(procedureRes.get(i).getId());
            System.out.println(procedureRes.get(i).getProcedure_name());
            System.out.print(procedureRes.get(i).getRole_id());
            System.out.println(procedureRes.get(i).getStep());
        }
    }

    @Test
    public void getProcedureDetail() throws Exception{
        Integer procedureID=1;
        ProcedureInfo procedureInfo=rolePlayService.getProcedureDetail(procedureID);
        System.out.print(procedureInfo.getId());
        System.out.println(procedureInfo.getProcedure_name());
        System.out.println(procedureInfo.getRole_id());
        System.out.println(procedureInfo.getInfo());
        if(procedureInfo.getVideoUrl().size()>0)
            System.out.println(procedureInfo.getVideoUrl().get(0));
        if(procedureInfo.getPicUrl().size()>0)
            System.out.println(procedureInfo.getPicUrl().get(0));
    }
}
