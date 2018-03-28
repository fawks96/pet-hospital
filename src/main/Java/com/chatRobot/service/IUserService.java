package com.chatRobot.service;

/**
 * Created by starr on 2018/3/7.
 */
import com.chatRobot.model.UserInfo;

public interface IUserService {

    //public User selectUser(long userId);

    public UserInfo checkLogin(String username, String password);

}
