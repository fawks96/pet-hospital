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
    private CaseInfoService caseInfoService;
    @Autowired
    private DiseaseInfoService diseaseInfoService;
    @Autowired
    private IUserService userService;

    @Test
    /*
    public void testSetDetail() throws Exception{
        Integer ID=2;
        CaseDetail detail=caseInfoService.getDetail(ID);
        System.out.println(detail.getID());
        System.out.println(detail.getPicUrl().size());
        System.out.println(detail.getVideoUrl().size());
        System.out.println(detail.getText().size());
    }*/
    /*
    @Test
    public void testSelectCaseByDisease() throws Exception{
        //List<CaseInfo> caseInfos = caseInfoService.getCaseByDisease("肺炎");
        List<CaseInfo> caseInfos = caseInfoService.getCaseByDisease("肺炎");
        for(int j=0;j<caseInfos.size();j++) {
            Integer id=caseInfos.get(j).getDiseaseId();
            System.out.println(id);
        }
        Integer ID=0;
        ID=caseInfoService.getDiseaseID("气管炎");
        System.out.println(ID);
        List<DiseaseInfo> diseaseInfos=testSelectDiseaseByCategory();
        for(int i=0;i<diseaseInfos.size();i++){
            DiseaseInfo diseaseInfo=diseaseInfos.get(i);
            if(diseaseInfo.getName().equals("肺炎"));
            List<CaseInfo> caseInfos = caseInfoService.getCaseByDisease(diseaseInfo.getId());
            for(int j=0;j<caseInfos.size();j++) {
                System.out.println(caseInfos.get(j).getDiseaseId());
            }
        }
    }*/


    public void testSelectDiseaseByCategory() throws Exception{
        /*String category="炎症";
        List<DiseaseInfo> diseaseInfo = diseaseInfoService.getDiseaseByCategory(category);
        return diseaseInfo;*/
        List<String> category=diseaseInfoService.getCategory();
        System.out.println("category 个数");
        System.out.println(category.size());
        List<Category> categoryList=new ArrayList<>();
        for(int i=0;i<category.size();i++){
            List<DiseaseInfo> diseaseInfos=diseaseInfoService.getDiseaseByCategory(category.get(i));
            System.out.println(diseaseInfos.size());
            Category category1=new Category();
            category1.setLable(category.get(i));
            category1.setChildren(diseaseInfos);
            categoryList.add(category1);
        }
        System.out.print(categoryList.size());
    }

    /*
    @Test
    public void testLogin() throws Exception{
        String name="admin";
        String password = "123";
        UserInfo user = userService.checkLogin(name, password);
        System.out.println(user.getPwd());
    }*/
}
