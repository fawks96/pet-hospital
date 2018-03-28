package com.chatRobot.service;

import com.chatRobot.model.CaseInfo;
import java.util.List;
/**
 * Created by starr on 2018/3/22.
 */
public interface CaseInfoService {
    public List<CaseInfo> getCaseByDisease(Integer diseaseID);
}
