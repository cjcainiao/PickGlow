package com.studentpulse.controller;

import com.studentpulse.common.Result;
import com.studentpulse.model.vo.UserLoginResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class index {


    @GetMapping
    public Result test(){
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        return Result.success(200,"成功返回",userLoginResponse);
    }
}
