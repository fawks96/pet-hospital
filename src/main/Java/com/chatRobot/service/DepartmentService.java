package com.chatRobot.service;

import com.chatRobot.model.DepartmentInfo;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentInfo> getAll();


    public List<Integer> getFacilityIds(Integer id);

    public List<Integer> getDrugIds(Integer id);
}
