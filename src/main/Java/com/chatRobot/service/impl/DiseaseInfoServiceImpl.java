package com.chatRobot.service.impl;

import com.chatRobot.dao.DiseaseInfoMapper;
import com.chatRobot.model.DiseaseInfo;
import com.chatRobot.service.DiseaseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by starr on 2018/3/28.
 */
@Service("DiseaseService")
public class DiseaseInfoServiceImpl implements DiseaseInfoService{
    @Resource
    private DiseaseInfoMapper dao;

    public List<DiseaseInfo> getDiseaseByCategory(String category){
        return dao.selectByCategory(category);
    }

    public  List<String> getCategory(){return dao.getCategory();}

    @Override
    public List<String> getAllCategory() {
        return dao.getAllCategory();
    }




}
