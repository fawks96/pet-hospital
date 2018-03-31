package com.chatRobot.controller;


import com.chatRobot.model.FacilityInfo;
import com.chatRobot.model.QuestionInfo;
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
@RequestMapping("/facility")
public class FacilityController {


    @Resource
    private FacilityService facilityService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    Map<Integer, Map<String, String>> getAllRoom () {

        List<FacilityInfo> facilityInfoList = facilityService.getAll();

        Map<Integer, Map<String, String>> map = new HashMap<Integer,Map<String,String>>();

        for (int i = 0; i < facilityInfoList.size(); i++) {


            FacilityInfo facilityInfo = facilityInfoList.get(i);

            Map<String,String> tmp2 = new HashMap<String,String>();

            tmp2.put("name",facilityInfo.getName());

            tmp2.put("info",facilityInfo.getInfo());

            tmp2.put("picture",facilityInfo.getPicture());

            map.put(facilityInfo.getId(),tmp2);


        }

        return map;
    }

}
