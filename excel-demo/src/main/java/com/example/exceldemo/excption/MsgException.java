package com.example.exceldemo.excption;

/**
 * @author zsc
 * date  2022/7/25
 * dec
 */
public class MsgException extends RuntimeException {
    public MsgException(String message) {
        super(message);
    }
}
