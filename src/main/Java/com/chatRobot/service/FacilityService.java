package com.chatRobot.service;
import com.chatRobot.model.FacilityInfo;
import java.util.*;
public interface FacilityService {

    public List<FacilityInfo> getAll();

    public FacilityInfo getById(Integer id);
}
