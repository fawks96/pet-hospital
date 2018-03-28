package com.chatRobot.controller;

/**
 * Created by starr on 2018/3/7.
 */
import javax.servlet.http.HttpServletRequest;

import com.chatRobot.model.UserInfo;
import com.chatRobot.service.IUserService;
import com.chatRobot.model.loginRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;
@Controller
@RequestMapping("/user")
public class UserController {


    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    loginRes login(@RequestBody Map<String,String> map) throws Exception {
        // user = userService.checkLogin(user.getUsername(), user.getPassword());
       // String username = request.getParameter("username");
        //String password = request.getParameter("password");
        String username = map.get("username");
        String password = map.get("password");
        UserInfo user = userService.checkLogin(username, password);
        System.out.println(username);
        loginRes myRes = new loginRes();
        if (user != null) {
            myRes.setStatus("Ok");
            myRes.setUser(user);
        } else {
            myRes.setStatus("Fail");
        }
        return myRes;

    }
}





    /*
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }*/

