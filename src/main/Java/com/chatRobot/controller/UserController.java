package com.chatRobot.controller;

/**
 * Created by starr on 2018/3/7.
 */

import com.chatRobot.model.UserInfo;
import com.chatRobot.service.IUserService;
import com.chatRobot.model.loginRes;
import com.chatRobot.model.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    loginRes login(@RequestBody Map<String, String> map) throws Exception {
        // user = userService.checkLogin(user.getUsername(), user.getPassword());
        // String username = request.getParameter("username");
        //String password = request.getParameter("password");
        String username = map.get("username");
        String password = map.get("password");
        UserInfo user = userService.checkLogin(username, password);
        //System.out.println(username);
        //System.out.println(password);
        loginRes myRes = new loginRes();
        if (user != null) {
            myRes.setStatus("Ok");
            myRes.setUser(user);
        } else {
            myRes.setStatus("Fail");
        }
        return myRes;

    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    loginRes register(@RequestBody UserInfo user) throws Exception {
        loginRes myRes = new loginRes();
        if(userService.selectByName(user.getName()).size()!=0){
            myRes.setStatus("repeat");
        }
        else {
            UserInfo res_user = userService.addUser(user);
            if (user != null) {
                myRes.setStatus("Ok");
                myRes.setUser(res_user);
            } else {
                myRes.setStatus("Fail");
            }
        }
        return myRes;

    }

    /**
     * 响应验证码页面
     * @return
     */
    public @ResponseBody
    @RequestMapping(value = "/validateCode", method = RequestMethod.GET)
    String validateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(120,40,5,100);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
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
}
