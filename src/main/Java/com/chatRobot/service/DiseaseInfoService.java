package com.chatRobot.service;

import com.chatRobot.model.DiseaseInfo;

import java.util.List;

import com.chatRobot.model.DiseaseInfo;

/**
 * Created by starr on 2018/3/28.
 */
public interface DiseaseInfoService {
    public List<DiseaseInfo> getDiseaseByCategory(String category);

    public List<String> getCategory();


    public List<DiseaseInfo> getAllCategory();
}
