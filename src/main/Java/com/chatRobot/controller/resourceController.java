package com.chatRobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/doc")
public class resourceController {

    @RequestMapping(value = "/framework", method = RequestMethod.GET)
    public String framework()
    {
        return "framework";
    }

    @RequestMapping(value = "/parameter_trans", method = RequestMethod.GET)
    public String parameter_trans()
    {
        return "parameter_trans";
    }

    @RequestMapping(value = "/parameter_trans2", method = RequestMethod.GET)
    public String parameter_trans2()
    {
        return "parameter_trans2";
    }

    @RequestMapping(value = "/deploy", method = RequestMethod.GET)
    public String deploy()
    {
        return "deploy";
    }

    @RequestMapping(value = "/deploy2", method = RequestMethod.GET)
    public String deploy2()
    {
        return "deploy2";
    }

    @RequestMapping(value = "/3d", method = RequestMethod.GET)
    public String dd()
    {
        return "3D";
    }

    @RequestMapping(value = "/3D", method = RequestMethod.GET)
    public String dd2()
    {
        return "3D";
    }

    @RequestMapping(value = "/performance", method = RequestMethod.GET)
    public String performance()
    {
        return "performance";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String fileUpload()
    {
        return "fileUpload";
    }
}

