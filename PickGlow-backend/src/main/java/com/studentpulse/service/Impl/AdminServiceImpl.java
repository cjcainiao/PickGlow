package com.studentpulse.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studentpulse.Annotation.ParameterHasNull;
import com.studentpulse.common.PageRequest;
import com.studentpulse.exception.BaseException;
import com.studentpulse.mapper.AdminMapper;
import com.studentpulse.model.entity.User;
import com.studentpulse.model.vo.UserInfoResponse;
import com.studentpulse.model.vo.UserPageListResponse;
import com.studentpulse.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.List;

/**
 * 管理员业务实现类
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, User> implements AdminService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @ParameterHasNull
    public UserInfoResponse getUserById(Long id) {
        //获取用户信息
        User user = query().eq("id", id).one();
        if(user == null){
            throw new BaseException(400,"用户不存在！");
        }
        return BeanUtil.copyProperties(user, UserInfoResponse.class);
    }

    /**
     * 分页获取用户信息
     * @param pageRequest
     * @return
     */
    @Override
    public UserPageListResponse pageQueryList(PageRequest pageRequest) {
        // 创建 Page 对象，指定页码和页面大小
        Page<User> page = new Page<>(pageRequest.getCurrent(),pageRequest.getPageSize());
        // 构造查询条件
        List<User> records = query().page(page).getRecords();

        UserPageListResponse userPageListResponse = BeanUtil.copyProperties(page, UserPageListResponse.class);
        userPageListResponse.setUserList(BeanUtil.copyToList(records, UserInfoResponse.class));
        userPageListResponse.setTotal(page.getTotal());
        userPageListResponse.setCurrent((int) page.getCurrent());
        userPageListResponse.setPageSize((int) page.getSize());

        return userPageListResponse;
    }
}
