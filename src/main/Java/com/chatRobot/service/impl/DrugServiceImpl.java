package com.chatRobot.service.impl;

import com.chatRobot.dao.DrugInfoMapper;
import com.chatRobot.dao.FacilityInfoMapper;
import com.chatRobot.model.DrugInfo;
import com.chatRobot.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DrugServiceImpl implements DrugService{

    @Resource
    private DrugInfoMapper dao;


    public DrugInfo getById(Integer id)
    {
        return dao.getById(id);

    }

}
