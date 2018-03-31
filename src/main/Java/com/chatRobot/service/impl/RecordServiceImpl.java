package com.chatRobot.service.impl;
import com.chatRobot.dao.RecordInfoMapper;
import com.chatRobot.model.RecordInfo;
import com.chatRobot.service.RecordService;
import org.springframework.stereotype.Service;
import java.util.*;
import javax.annotation.Resource;
@Service
public class RecordServiceImpl implements RecordService{

    @Resource
    private RecordInfoMapper dao;

    public void addRecord(Integer user_id,Integer ques_id,String choose_ans,String TorF)
    {
        System.out.println("service2:"+user_id+ques_id+choose_ans+TorF);
        RecordInfo recordInfo = new RecordInfo();
        recordInfo.setUser_id(user_id);
        recordInfo.setChoice(choose_ans);
        recordInfo.setQues_id(ques_id);
        recordInfo.setTorF(TorF);
        this.dao.addRecord(recordInfo);
    }

    public List<RecordInfo> getRecordById(Integer user_id)
    {
        return this.dao.getRecordById(user_id);
    }


}
