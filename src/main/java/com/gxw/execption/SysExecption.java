package com.gxw.execption;

/**
 * 异常处理类
 * @author GXW工作室
 * @date 2020/6/12 0012 - 11:00
 */
public class SysExecption extends Exception{
    //定义私有全局变量
    private String message;

    //异常处理
    public SysExecption() {
    }

    public SysExecption(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
