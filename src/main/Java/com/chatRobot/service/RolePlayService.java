package com.chatRobot.service;

import com.chatRobot.model.ProcedureInfo;
import com.chatRobot.model.procedureRes;
import java.util.List;

/**
 * Created by starr on 2018/3/31.
 */
public interface RolePlayService {
    public List<procedureRes> getRoleProcedure(Integer role,String domain);

    public ProcedureInfo getProcedureDetail(Integer procedureID);

    public List<String> getAllDomain(Integer role);
}
