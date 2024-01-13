package com.example.exceldemo.handler;


import com.example.exceldemo.excption.MsgException;
import com.example.exceldemo.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: liuzhiyu
 * @version: 1.0
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = MsgException.class)
    Result<Object> exceptionHandler(MsgException ex) {
        return Result.fail(ex.getMessage());
    }
}
