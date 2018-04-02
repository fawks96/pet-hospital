package com.chatRobot.model;

import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by starr on 2018/3/31.
 */
public class procedureRes {
    private Integer role_id;
    private Integer step;
    private Integer id;
    private String step_name;

    public Integer getRole_id(){return this.role_id;}

    public void setRole_id(Integer role){this.role_id=role;}

    public Integer getStep(){return this.step;}

    public void setStep(Integer stage){this.step=stage;}

    public String getStep_name(){return this.step_name;}

    public void setStep_name(String procedureName){this.step_name=procedureName;}

    public Integer getId(){return this.id;}

    public void setId(Integer procedureID){this.id=procedureID;}
}
