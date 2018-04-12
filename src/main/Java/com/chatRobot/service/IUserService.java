package com.chatRobot.service;

/**
 * Created by starr on 2018/3/7.
 */
import com.chatRobot.model.UserInfo;
import java.util.List;
public interface IUserService {

    //public User selectUser(long userId);

    public UserInfo checkLogin(String username, String password);

    public UserInfo addUser(UserInfo user);

    public List<UserInfo> selectByName(String name);
}
