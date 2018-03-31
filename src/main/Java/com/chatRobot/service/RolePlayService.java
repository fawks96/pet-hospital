package com.chatRobot.service;

import com.chatRobot.model.ProcedureInfo;
import com.chatRobot.model.procedureRes;
import java.util.List;

/**
 * Created by starr on 2018/3/31.
 */
public interface RolePlayService {
    public List<procedureRes> getRoleProcedure(Integer role);

    public ProcedureInfo getProcedureDetail(Integer procedureID);
}
