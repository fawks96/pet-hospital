package com.chatRobot.controller;


import com.chatRobot.model.QuestionInfoExample;
import com.chatRobot.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chatRobot.model.QuestionInfo;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import net.sf.json.JSONArray;
import com.chatRobot.service.TestService;
import com.chatRobot.model.getQueData;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/test")
public class testController {

    @Resource
   // @Autowired
    private TestService testService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public @ResponseBody List<QuestionInfo> getQuestions(HttpServletRequest request)
    {
        String category = request.getParameter("category");
        int num = Integer.parseInt(request.getParameter("num"));

        List<QuestionInfo> questionList = testService.getByCategory(category);

        int len = questionList.size();

        if (len <= num)
        {
            return questionList;
        }
        else
        {
            List<QuestionInfo> newQuestionList = new ArrayList<>();
            for (int i = 0; i < num; i++)
            {
                newQuestionList.add(questionList.get(i));
            }
            return newQuestionList;

        }

    }

   /*@RequestMapping(value = "/questions2", method = RequestMethod.POST)
    public @ResponseBody void getQuestions2(@RequestBody Map<String,String> map)
    {
        System.out.println("fuck");
        int num = Integer.parseInt(map.get("num"));
        System.out.println(num);

        JSONObject myJson = JSONObject.fromObject(map.get("CategoryList"));
        //JSONArray list = new JSONArray("233");
        JSONArray list = myJson.getJSONArray();
        for (int i = 0; i < list.length(); i++)
        {
            System.out.println(list.getString(i));
        }
    //    System.out.println(quedata.getNum());
      //  System.out.println(quedata.getCategoryList());
   /*     List<String> CategoryList = quedata.getCategoryList();
        int num = quedata.getNum();
        for (int i = 0; i < CategoryList.size(); i++) System.out.println(CategoryList.get(i));
        System.out.println("num:"+num);

        List<QuestionInfo> questionList = new ArrayList<>();

        for (int i = 0; i < CategoryList.size(); i++)
        {
            List<QuestionInfo> tmpList = testService.getByCategory(CategoryList.get(i));
            for (int j = 0; j < tmpList.size(); j++)
            {
                questionList.add(tmpList.get(j));
            }

        }

        int len = questionList.size();

        if (num >= len)
        {
            return questionList;
        }
        else
        {
            List<QuestionInfo> resList = new ArrayList<>();
            for (int i = 0; i < num; i++) resList.add(questionList.get(i));
            return resList;
        }
      //  testService.getByCategory(category);

        }
            */
    }


