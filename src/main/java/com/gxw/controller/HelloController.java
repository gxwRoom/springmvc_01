package com.gxw.controller;

import com.gxw.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


    /**
     * 获取Servlet原生API
     * @return
     */
    @RequestMapping(path = "/testServletAPI",method = RequestMethod.POST)
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("获取request请求："+request);
        System.out.println("获取response请求："+response);
        HttpSession requestSession = request.getSession();
        System.out.println("获取session请求："+requestSession);
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        return "success";
    }


    /**
     * RequestBody注解：获取请求体内容
     * @return
     */
    @RequestMapping(path = "/getRequestBody",method = RequestMethod.POST)
    public String getRequestBody(@RequestBody String body){
        System.out.println("获取请求体内容："+body);
        return "success";
    }


    /**
     * SpringMVC里面返回值类型：
     *    1.字符串String类型
     */
    @RequestMapping(path = "/testString")
    public String testString(Model model){
        User user = new User();
        user.setUid(101);
        user.setUsername("张三");
        user.setPassword("333");
        user.setMoney(6000.0);
        System.out.println("字符串String类型执行了");
        model.addAttribute("user",user);
        return "success";
    }


    /**
     * SpringMVC里面返回值类型：
     *    1.void类型
     *    使用请求转发进行跳转
     */
    @RequestMapping(path = "/testVoid")
    public void testVoid(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("请求转发执行了");
        request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request,response);
    }


    /**
     * SpringMVC里面返回值类型：
     *    1.void类型
     *    使用请求转发进行跳转
     */
    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView model = new ModelAndView();
        model.addObject("username","李四");
        model.addObject("password","444");
        model.addObject("money",5000.0);
        model.setViewName("success");
        System.out.println("请求转发执行了");
        return model;
    }


    /**
     * Ajax进行异步请求
     *   @RequestBody 获取请求体内容
     */
    @RequestMapping(path = "/testAjax1")
    public void testAjax(@RequestBody String body) {
        System.out.println("testAjax执行了："+body);
    }


    /**
     * 返回Json数据
     *   @RequestBody 获取请求体内容
     *   因为前端是json对象，所以使用@ResponseBody将user对象转换成json对象才可使用
     */
    @RequestMapping(path = "/testJson")
    public @ResponseBody User testJson(@RequestBody User user) {
        //客户端发送的ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println("testJson执行了："+user);
        //做响应，模拟去查询数据库，显然查询到的数据和前端数据不一样
        user.setUsername("张三");
        user.setMoney(300.0);
        //做响应
        return user;
    }
}
