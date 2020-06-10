package com.gxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * SpringMVC文件上传控制器
 * @author GXW工作室
 * @date 2020/6/11 0011 - 00:22
 */
@Controller(value = "FileUploadController")
@RequestMapping("/user")
public class FileUploadController {
    /**
     * SpringMVC文件上传
     */
    @RequestMapping(path = "/fileUpload")
    public String fileUpload(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("执行SpringMVC文件上传...");
        //1.获取文件上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //2.判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //如果文件路径不存在，则创建新的文件路径
            file.mkdirs();
        }
        //3.获取原始上传文件的名称
        String filename = upload.getOriginalFilename();
        //4.截取文件扩展名称
        String subName = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
        //5.通过uuid把文件加上随机数，防止文件重复
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //6.通过Multipart的接口方法，把上传的文件写到指定位置  文件位置和文件名称
        upload.transferTo(new File(path,filename));
        return "success";
    }
}
