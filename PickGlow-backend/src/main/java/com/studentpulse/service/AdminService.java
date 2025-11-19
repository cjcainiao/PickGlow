package com.studentpulse.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.studentpulse.common.PageRequest;
import com.studentpulse.model.entity.User;
import com.studentpulse.model.vo.UserInfoResponse;
import com.studentpulse.model.vo.UserPageListResponse;

/**
 * 管理员相关业务接口
 */
public interface AdminService extends IService<User> {
    UserInfoResponse getUserById(Long id);

    UserPageListResponse pageQueryList(PageRequest pageRequest);
}
