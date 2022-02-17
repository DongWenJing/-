package com.jt.aop;

import com.jt.vo.SysResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//@RestController  //拦截Controller层的异常
//@RequestBody    //返回的数据为json串
@RestControllerAdvice
public class SystemExceptionAOP {

    /** 通过方法实现程序的控制
     * 1.返回值就是响应给用户的数据
     * 2.参数信息,使用异常累成进行接收
     * 3.规则:如果controller层抛出异常,则将异常信息
     *  参数,传递给exception
     * 4.注解支持:@ExceptionHandler 拦截指定的异常类型
     */
    @ExceptionHandler(RuntimeException.class)
    public SysResult fail(Exception exception){
        //打印异常信息
        exception.printStackTrace();
        return  SysResult.fail();
    }

}
