package com.studentpulse.controller;


import com.studentpulse.Annotation.Administrator;
import com.studentpulse.common.PageRequest;
import com.studentpulse.common.Result;
import com.studentpulse.model.vo.UserInfoResponse;
import com.studentpulse.model.vo.UserPageListResponse;
import com.studentpulse.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理员相关接口
 */

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Resource
    private AdminService adminService;
    /**
     * 管理员获取用户信息
     * @param id
     * @return
     */
    @Administrator
    @GetMapping("/getUserById/{id}")
    public Result getUserById(@PathVariable Long id){
        UserInfoResponse user = adminService.getUserById(id);
        return Result.success(200,"获取用户信息成功！",user);
    }

    /**
     * 管理员分页获取用户信息
     * @param pageRequest
     * @return
     */
    @GetMapping ("/page")
    @Administrator
    public Result page(PageRequest pageRequest){

        UserPageListResponse userPageListResponse = adminService.pageQueryList(pageRequest);

        return Result.success(200,"获取用户信息成功！",userPageListResponse);
    }


}
