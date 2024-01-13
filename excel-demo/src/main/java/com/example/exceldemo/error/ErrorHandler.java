package com.example.exceldemo.error;


import com.example.exceldemo.excption.MsgException;
import com.example.exceldemo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author shangml
 * dec 异常处理
 */
@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class ErrorHandler {
    /**
     * 传入的数据类型异常报错归为业务报错
     *
     * @param e 导常
     * @return 结果对象
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private Result<Boolean> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String msg = "不能为空";
        if (msg.equals(message)) {
            message = str[1] + ":" + message;
        }
        e.printStackTrace();
        return Result.fail(message);
    }

    @ExceptionHandler({MsgException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private Result<Boolean> msgException(MsgException e) {
        String message = e.getMessage();
        e.printStackTrace();
        return Result.fail(message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private Result<Boolean> httpMessageNotException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        e.printStackTrace();
        return Result.fail(message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private Result<Boolean> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return Result.fail(e.getMessage());
    }

}
