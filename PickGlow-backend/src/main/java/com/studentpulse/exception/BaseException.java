package com.studentpulse.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义异常类
 */
@Data
public class BaseException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer code;

    private Object data;

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.data = null;
    }

    public BaseException(ErrorCode errorCode, Object data) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.data = data;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.data = null;
    }

    public BaseException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public BaseException(String message) {
        super(message);
        this.code = 500; // 默认系统错误码
        this.data = null;
    }


    public BaseException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause); // 传入根异常，保留异常链
        this.code = errorCode.getCode();
        this.data = null;
    }

}

