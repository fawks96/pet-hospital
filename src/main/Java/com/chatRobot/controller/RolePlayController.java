package com.chatRobot.controller;

import com.chatRobot.model.procedureRes;
import com.chatRobot.model.ProcedureInfo;
import com.chatRobot.service.RolePlayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by starr on 2018/3/31.
 */
@Controller
@RequestMapping("/rolePlay")
public class RolePlayController {
    @Resource
    private RolePlayService rolePlayService;

    public @ResponseBody
    @RequestMapping(value = "/getRoleProcedure", method = RequestMethod.GET)
    List<procedureRes> getDisease(HttpServletRequest request) throws Exception {
        Integer role=Integer.parseInt(request.getParameter("role"));
        List<procedureRes> procedureRes=rolePlayService.getRoleProcedure(role);
        return procedureRes;
    }

    public @ResponseBody
    @RequestMapping(value = "/getProcedureDetail",method = RequestMethod.GET)
    ProcedureInfo getProcedureDetail(HttpServletRequest request) throws Exception{
        Integer procedureID=Integer.parseInt(request.getParameter("procedureID"));
        ProcedureInfo procedureInfo=rolePlayService.getProcedureDetail(procedureID);
        return procedureInfo;
    }
}
