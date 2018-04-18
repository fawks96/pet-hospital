package com.chatRobot.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import javax.servlet.ServletContext;
import java.io.*;
import org.springframework.stereotype.Controller;
import com.chatRobot.model.fileRes;
@Controller
@RequestMapping("/file")
public class ImgUploadController {


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody fileRes oneFileUpload(
            @RequestParam("file") CommonsMultipartFile file,
            HttpServletRequest request) {

        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);

        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;

        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录

        fileRes res = new fileRes();

        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
                res.setStatus("Ok");
            } catch (Exception e) {
                res.setStatus("fail");
                e.printStackTrace();
            }
        }
        else res.setStatus("Fail");
        res.setFileURL(path+newFileName);
        res.setWebURL("img/"+newFileName);
        System.out.println("上传图片到:" + path + newFileName);
        return res;

    }

}