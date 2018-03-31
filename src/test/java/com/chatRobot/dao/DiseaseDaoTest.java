package com.chatRobot.dao;

import com.chatRobot.model.Category;
import com.chatRobot.model.DiseaseInfo;
import com.chatRobot.service.DiseaseInfoService;
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
public class DiseaseDaoTest {
    @Autowired
    private DiseaseInfoService diseaseInfoService;
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
}
