package com.studentpulse.controller;

import com.studentpulse.common.Result;
import com.studentpulse.model.dto.UserLoginRequest;
import com.studentpulse.model.dto.UserRegisterRequest;
import com.studentpulse.model.entity.User;
import com.studentpulse.model.vo.UserInfoResponse;
import com.studentpulse.model.vo.UserLoginResponse;
import com.studentpulse.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public Result register( @RequestBody UserRegisterRequest userRegisterRequest){
        userService.userRegister(userRegisterRequest);
        return Result.success(200,"注册成功！");
    }


    /**
     * 用户登录
     * @param userLoginRequest
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginRequest userLoginRequest){
        UserLoginResponse userLoginResponse = userService.userLogin(userLoginRequest);

        System.out.println(userLoginResponse.toString());
        return Result.success(200,"登录成功！",userLoginResponse);
    }


    /**
     * 用户注销
     * @param id
     * @return
     */
    @GetMapping("/logout/{id}")
    public Result logout(@PathVariable Long id){
        userService.logout(id);
        return Result.success(200,"退出成功！");
    }


    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getUserInfo")
    public Result getUserInfo(){

        UserInfoResponse userInfo = userService.getUserInfo();
        return Result.success(200,"获取用户信息成功!",userInfo);
    }

    /**
     * 修改用户信息
     * @return
     */
    //todo 简单修改，后续在调整
    @PutMapping("/updateUserInfo")
    public Result updateUserInfo(User user){
        userService.updateUserInfoById(user);
        return Result.success(200,"修改用户信息成功!");
    }


}
