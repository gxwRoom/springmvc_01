package com.gxw.execption;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理
 * @author GXW工作室
 * @date 2020/6/12 0012 - 11:11
 */
public class SysExecptionResolver implements HandlerExceptionResolver{
    /**
     * 跳转到具体的错误页面的方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) {
        SysExecption se = null;

        //1.获取异常处理对象
        if(ex instanceof SysExecption){
            //进行类型强制转换
            se = (SysExecption)ex;
        }else {
            se = new SysExecption("请联系系统管理员!");
        }
        //2.创建ModelAndView对象
        ModelAndView model = new ModelAndView();
        model.addObject("errorMsg",ex.getMessage());
        model.setViewName("error");
        return model;
    }
}
