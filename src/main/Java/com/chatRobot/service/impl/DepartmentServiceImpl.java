package com.chatRobot.service.impl;

import com.chatRobot.dao.DepartmentInfoMapper;
import com.chatRobot.model.DepartmentInfo;
import com.chatRobot.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    private DepartmentInfoMapper dao;
    public List<DepartmentInfo> getAll()
    {
        return dao.selectAll();
    }
}
