package com.chatRobot.controller;

import com.chatRobot.model.CaseDetail;
import com.chatRobot.model.CaseInfo;
import com.chatRobot.model.DiseaseInfo;
import com.chatRobot.service.CaseInfoService;
import com.chatRobot.service.DiseaseInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chatRobot.model.Category;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by starr on 2018/3/28.
 */
@Controller
@RequestMapping("/case")
public class CaseController {
    @Resource
    private CaseInfoService caseInfoService;
    @Resource
    private DiseaseInfoService diseaseInfoService;

    private List<DiseaseInfo> diseaseInfos;
    private  List<CaseInfo> caseInfos;

    public @ResponseBody
    @RequestMapping(value = "/getallDisease", method = RequestMethod.GET)
    List<Category> getDisease(HttpServletRequest request) throws Exception {

        /*String category=request.getParameter("category");
        category= URLDecoder.decode(category,"UTF-8");
        System.out.println(category);
        diseaseInfos=diseaseInfoService.getDiseaseByCategory(category);*/

        List<String> category=diseaseInfoService.getCategory();
        List<Category> categoryList=new ArrayList<>();
        for(int i=0;i<category.size();i++){
            List<DiseaseInfo> diseaseInfos=diseaseInfoService.getDiseaseByCategory(category.get(i));
            Category category1=new Category();
            category1.setLable(category.get(i));
            //System.out.print(category1.getName());
            category1.setChildren(diseaseInfos);
            categoryList.add(category1);
        }

        return categoryList;
    }

    public @ResponseBody
    @RequestMapping(value="/getCase",method = RequestMethod.GET)
    List<CaseInfo> getCase(HttpServletRequest request) throws Exception{
        Integer diseaseID=Integer.parseInt(request.getParameter("diseaseID"));
        caseInfos=caseInfoService.getCaseByDisease(diseaseID);
        /*if(!diseaseInfos.isEmpty()){
            for(int i=0;i<diseaseInfos.size();i++){
                DiseaseInfo diseaseInfo=diseaseInfos.get(i);
                if(diseaseInfo.getName().equals(diseaseName)){
                    caseInfos=caseInfoService.getCaseByDisease(diseaseInfo.getName());
                }
            }
        }
        else
            return null;*/
        return caseInfos;
    }

    public @ResponseBody
    @RequestMapping(value="/getCaseDetail",method = RequestMethod.GET)
    CaseDetail getDetail(HttpServletRequest request) throws Exception{
        Integer caseID=Integer.parseInt(request.getParameter("caseID"));
        CaseDetail detail=caseInfoService.getDetail(caseID);
        System.out.println(caseID);
        System.out.println(detail.getID());
        return  detail;
    }

}
