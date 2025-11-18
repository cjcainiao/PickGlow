package com.studentpulse.model.vo;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserInfoResponse implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;


    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户简介
     */
    private String profile;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 账号是否正常
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

}
