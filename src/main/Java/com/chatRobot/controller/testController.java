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
import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.*;
import com.chatRobot.service.TestService;
import com.chatRobot.model.questionsRes;
import com.chatRobot.service.RecordService;
@Controller
@RequestMapping("/test")
public class testController {

    @Resource
    // @Autowired
    private TestService testService;

    @Resource
    private RecordService recordService;

    @RequestMapping(value = "/questions2", method = RequestMethod.GET)
    public @ResponseBody
    List<QuestionInfo> getQuestions2(HttpServletRequest request) {
        String category = request.getParameter("category");
        int num = Integer.parseInt(request.getParameter("num"));

        List<QuestionInfo> questionList = testService.getByCategory(category);

        int len = questionList.size();

        if (len <= num) {
            return questionList;
        } else {
            List<QuestionInfo> newQuestionList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                newQuestionList.add(questionList.get(i));
            }
            return newQuestionList;

        }

    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public @ResponseBody
    questionsRes getQuestions(@RequestBody Map<String, Object> map) {
    //    System.out.println("fuck");

        questionsRes myRes = new questionsRes();

        int num = Integer.parseInt(map.get("num").toString());

        System.out.println(num);
        ArrayList CategoryList = (ArrayList) map.get("CategoryList");
  /*      System.out.println(CategoryList.size());
        for (int i = 0; i < CategoryList.size(); i++)
        {
            System.out.println(CategoryList.get(i));
        }*/



        List<QuestionInfo> questionList = new ArrayList<>();

        for (int i = 0; i < CategoryList.size(); i++)
        {
            List<QuestionInfo> tmpList = testService.getByCategory(CategoryList.get(i).toString());
            for (int j = 0; j < tmpList.size(); j++)
            {
                questionList.add(tmpList.get(j));
            }

        }

        int len = questionList.size();

        if (num >= len)
        {
            if (questionList == null) myRes.setStatus("Fail");
            else if (questionList.size() == 0) myRes.setStatus("题库暂空");
            else myRes.setStatus("Ok");

            myRes.setQuestionList(questionList);
            return myRes;
        }
        else
        {
            List<QuestionInfo> resList = new ArrayList<>();
            for (int i = 0; i < num; i++) resList.add(questionList.get(i));

            if (resList == null) myRes.setStatus("Fail");
            else if (resList.size() == 0) myRes.setStatus("题库暂空");
            else myRes.setStatus("Ok");

            myRes.setQuestionList(resList);
            return myRes;
        }

    }


        @RequestMapping(value = "/getScore", method = RequestMethod.POST)
        public @ResponseBody int
        getScore(@RequestBody Map<String,Object> map)
        {
            Integer user_id = Integer.parseInt(map.get("user_id").toString());

            ArrayList<Map<String,String> > selectList = (ArrayList<Map<String,String> >) map.get("select");

            int cnt = 0;

            for (int i = 0; i <selectList.size(); i++)
            {
                Integer ques_id = Integer.parseInt(selectList.get(i).get("ques_id"));
                String choose_ans = selectList.get(i).get("choose_ans");

                String ans = testService.getAnsById(ques_id);

                System.out.println("ans: "+ ans);
                System.out.println("choose_ans: "+choose_ans);
                if (choose_ans.equals(ans))
                {
                    recordService.addRecord(user_id,ques_id,choose_ans,"T");
                    cnt++;
                }
                else
                {
                    recordService.addRecord(user_id,ques_id,choose_ans,"F");
                }
            }

            return cnt*10; //答对一题10分

        }



}


