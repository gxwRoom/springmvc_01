package com.gxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器
 * @author GXW工作室
 * @date 2020/6/9 0009 - 22:57
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

//    @RequestMapping(path = "/sayHello")
//    public String sayHello(){
//        System.out.println("---->执行了 hello word!");
//        return "success";
//    }

    @RequestMapping(value = "/sayHello")
    public String sayHello(){
        System.out.println("---->执行了 hello word!");
        return "success";
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(String username,String password,Double money){
        System.out.println("姓名："+username+"密码："+password+"金额："+money);
        return "success";
    }
}
