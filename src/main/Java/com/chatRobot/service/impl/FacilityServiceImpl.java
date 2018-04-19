package com.chatRobot.service.impl;

import com.chatRobot.service.FacilityService;
import java.util.*;
import com.chatRobot.model.FacilityInfo;
import com.chatRobot.dao.FacilityInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class FacilityServiceImpl implements FacilityService{

    @Resource
    private FacilityInfoMapper dao;
    public List<FacilityInfo> getAll()
    {
        return dao.selectAll();
    }

    public FacilityInfo getById(Integer id)
    {
        return dao.getById(id);
    }

}
