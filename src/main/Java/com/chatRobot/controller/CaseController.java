package com.chatRobot.controller;

import com.chatRobot.model.*;
import com.chatRobot.service.CaseInfoService;
import com.chatRobot.service.DiseaseInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    caseRes getCase(HttpServletRequest request) throws Exception{
        Integer diseaseID=Integer.parseInt(request.getParameter("diseaseID"));
        Integer page=Integer.parseInt(request.getParameter("page"));
        Integer size=Integer.parseInt(request.getParameter("size"));
        List<CaseInfo> res=new ArrayList<>();
        caseRes caseRes=new caseRes();
        caseInfos=caseInfoService.getCaseByDisease(diseaseID);
        if((page-1)*size<caseInfos.size()){
            if((page*size-1)<caseInfos.size())
                res=caseInfos.subList((page-1)*size,(page*size));
            else
                res=caseInfos.subList((page-1)*size,caseInfos.size());
        }
        System.out.println((page-1)*size);
        System.out.println(page*size-1);
        if(res.size()>0)
            caseRes.setCaseInfoList(res);
        caseRes.setCount(caseInfos.size());
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
        return caseRes;
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


    public @ResponseBody
    @RequestMapping(value="/getAllCategory",method = RequestMethod.GET)
    List<String> getDetail() throws Exception{


         List<DiseaseInfo> list = diseaseInfoService.getAllCategory();

         List<String> resList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++)
         {
             resList.add(list.get(i).getCategory());

         }
         Set set = new HashSet();
         List<String>newList = new ArrayList();
         for (String cd:resList)
         {
             if (set.add(cd))
             {
                 newList.add(cd);
             }
         }
         return newList;

    }
}