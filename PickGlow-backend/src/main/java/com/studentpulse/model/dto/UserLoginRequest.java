package com.studentpulse.model.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录相关请求参数
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

}
