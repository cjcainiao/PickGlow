package com.studentpulse.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.studentpulse.model.dto.UserLoginRequest;
import com.studentpulse.model.dto.UserRegisterRequest;
import com.studentpulse.model.entity.User;
import com.studentpulse.model.vo.UserInfoResponse;
import com.studentpulse.model.vo.UserLoginResponse;


/**
 * 用户相关业务接口
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userRegisterRequest
     */
    public void userRegister(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     * @param userLoginRequest
     */
    UserLoginResponse userLogin(UserLoginRequest userLoginRequest);

    /**
     * 用户注销
     * @param id
     */
    void logout(Long id);

    /**
     * 获取用户信息
     * @return
     */
    UserInfoResponse getUserInfo();



}
