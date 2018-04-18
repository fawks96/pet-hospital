package com.chatRobot.controller;

import com.chatRobot.model.DepartmentInfo;
import com.chatRobot.model.FacilityInfo;
import com.chatRobot.model.QuestionInfo;
import com.chatRobot.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chatRobot.service.FacilityService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    Map<Integer, Map<String, String>> getAllRoom () {

        List<DepartmentInfo> departmentInfoList = departmentService.getAll();

        Map<Integer, Map<String, String>> map = new HashMap<Integer,Map<String,String>>();

        for (int i = 0; i < departmentInfoList.size(); i++) {


            DepartmentInfo departmentInfo = departmentInfoList.get(i);

            Map<String,String> tmp2 = new HashMap<String,String>();

            tmp2.put("name",departmentInfo.getName());

            tmp2.put("info",departmentInfo.getInfo());

            tmp2.put("role",departmentInfo.getRole().toString());

            tmp2.put("picture",departmentInfo.getPicture());

            map.put(departmentInfo.getId(),tmp2);


        }

        return map;
    }

}
