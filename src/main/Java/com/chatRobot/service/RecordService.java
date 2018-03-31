package com.chatRobot.service;

import com.chatRobot.model.RecordInfo;
import java.util.*;
public interface RecordService {

    public void addRecord(Integer user_id,Integer ques_id,String choose_ans,String TorF);

    public List<RecordInfo> getRecordById(Integer user_id);

}
