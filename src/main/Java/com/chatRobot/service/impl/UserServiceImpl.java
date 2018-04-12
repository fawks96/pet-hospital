package com.chatRobot.service.impl;

/**
 * Created by starr on 2018/3/7.
 */
import com.chatRobot.dao.UserInfoMapper;
import com.chatRobot.model.UserInfo;
import com.chatRobot.service.IUserService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements IUserService {


    @Resource
    private UserInfoMapper userDao;

    /* 登陆验证 */
    public UserInfo checkLogin(String username, String password) {
        //根据用户名实例化用户对象
        /*
        UserInfo user = userDao.findUserByName(username);
        if (user != null && user.getPwd().equals(password)) {
            return user;
        }*/
        return null;
    }

    public UserInfo addUser(UserInfo user)
    {
        //userDao.adduser(user);
        int i=userDao.insert(user);
        return user;
    }

    public List<UserInfo> selectByName(String name){
        List<UserInfo> user=userDao.findUserByName(name);
        return user;
    }

}

/*@Service("userService")
public class UserServiceImpl implements IUserService {



    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}*/
