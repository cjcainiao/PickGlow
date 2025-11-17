package com.studentpulse.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册接收请求
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String checkPassword;

}
