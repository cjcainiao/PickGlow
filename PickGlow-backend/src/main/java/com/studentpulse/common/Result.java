package com.studentpulse.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 全局统一响应类
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code; //响应状态码

    private String msg; //响应消息

    private Object data;//响应数据

    private Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result success(Integer code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result success(Integer code) {
        return new Result(code, null, null);
    }

    public static Result error(Integer code) {
        return new Result(code, null, null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg, null);
    }
}
