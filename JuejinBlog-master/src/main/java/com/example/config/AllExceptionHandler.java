package com.example.config;

import com.example.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理系统异常
 * 如果后台报错，不让前台接收到后台的报错，转变成返回前端一个-999，前端再特盘
 */

//对加了@Controller注解的方法进行AOP增强
@ControllerAdvice
@Slf4j
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e){
        e.printStackTrace();
        return Result.fail(-999,"系统异常");
    }


}
