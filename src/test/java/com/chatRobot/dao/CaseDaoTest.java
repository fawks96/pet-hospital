package com.chatRobot.dao;

import com.chatRobot.model.Category;
import com.chatRobot.service.CaseInfoService;
import com.chatRobot.service.DiseaseInfoService;
import com.chatRobot.model.CaseDetail;
import com.chatRobot.model.CaseInfo;
import com.chatRobot.model.DiseaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by starr on 2018/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class CaseDaoTest {
    @Autowired
    private CaseInfoService caseInfoService;
    @Autowired
    private DiseaseInfoService diseaseInfoService;

    @Test

    public void testSetDetail() throws Exception{
        Integer ID=2;
        CaseDetail detail=caseInfoService.getDetail(ID);
        System.out.println(detail.getID());
        System.out.println(detail.getStages().size());
        //System.out.println(detail.getStages().get(0).getPicURL().size());
        //System.out.println(detail.getText().size());
    }

    @Test
    public void testSelectCaseByDisease() throws Exception {
        //List<CaseInfo> caseInfos = caseInfoService.getCaseByDisease("肺炎");
        List<CaseInfo> caseInfos = caseInfoService.getCaseByDisease(2);
        for (int j = 0; j < caseInfos.size(); j++) {
            Integer id = caseInfos.get(j).getDiseaseId();
            System.out.println(id);
        }
        Integer ID = 0;
        ID = caseInfoService.getDiseaseID("气管炎");
        System.out.println(ID);
        List<DiseaseInfo> diseaseInfos = testSelectDiseaseByCategory();
        for (int i = 0; i < diseaseInfos.size(); i++) {
            DiseaseInfo diseaseInfo = diseaseInfos.get(i);
            if (diseaseInfo.getName().equals("肺炎")) ;
            List<CaseInfo> caseInfos1 = caseInfoService.getCaseByDisease(diseaseInfo.getId());
            for (int j = 0; j < caseInfos1.size(); j++) {
                System.out.println(caseInfos1.get(j).getDiseaseId());
            }
        }
    }

        public List<DiseaseInfo> testSelectDiseaseByCategory () throws Exception {
            String category = "炎症";
            List<DiseaseInfo> diseaseInfo = diseaseInfoService.getDiseaseByCategory(category);
            return diseaseInfo;
        }
}
