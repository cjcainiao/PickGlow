package com.studentpulse.service.Impl;



import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.benmanes.caffeine.cache.Cache;
import com.studentpulse.Annotation.ParameterHasNull;
import com.studentpulse.common.Result;
import com.studentpulse.common.utils.JwtUtil;
import com.studentpulse.common.utils.PasswordUtil;
import com.studentpulse.exception.BaseException;
import com.studentpulse.mapper.UserMapper;
import com.studentpulse.model.dto.UserLoginRequest;
import com.studentpulse.model.dto.UserRegisterRequest;
import com.studentpulse.model.entity.User;
import com.studentpulse.model.vo.UserLoginResponse;
import com.studentpulse.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户相关业务
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private Cache<Long, User> userCache;

    /**
     * 注册功能业务
     * @param userRegisterRequest
     */
    @ParameterHasNull
    public void userRegister(UserRegisterRequest userRegisterRequest) {

        //1、判断两次密码是否一致
        if(!userRegisterRequest.getPassword().equals(userRegisterRequest.getCheckPassword())){
            throw new BaseException("两次密码不一致！");
        }

        //2、判断用户名是否被使用
        Long count = query().eq("user_name", userRegisterRequest.getUserName()).count();
        if(count>0) {
            throw new BaseException("用户已存在!");
        }

        //3、对密码进行加密操作
        User user = BeanUtil.copyProperties(userRegisterRequest, User.class);
        String password = PasswordUtil.Encrypt(user.getPassword());
        user.setPassword(password);

        //4、保存用户信息
        boolean save = save(user);
        if(!save){
            log.error("用户注册失败....");
            throw new BaseException("注册失败");
        }
    }


    /**
     * 用户登录业务
     * @param userLoginRequest
     */
    @ParameterHasNull
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest) {
        //1、判断用户是否在线,先拿到用户id
        User user = query().eq("user_name", userLoginRequest.getUserName()).one();
        Object o = userCache.getIfPresent(user.getId());
        if(o!= null){
            throw new BaseException("请勿重复登录！");
        }

        //2、判断用户账号状态是否正常
        if(user.getStatus()!= 1) {
            throw new BaseException("当前账号状态异常，请及时联系管理员!");
        }

        //3、校验账号和密码
        String userName = user.getUserName();
        if(!(userName.equals(userLoginRequest.getUserName()) && PasswordUtil.checkPassword(userLoginRequest.getPassword(),user.getPassword()))){
            throw  new BaseException("用户名或密码错误！");
        }

        //4、生成唯一token
        Map<String,Object> mp  = new HashMap<>();
        mp.put("id",user.getId());
        mp.put("name",user.getUserName());
        String token = JwtUtil.createToken(mp);

        //5、缓存用户登录信息
        //todo 后续可以考虑缓存到redis中
        UserLoginResponse userLoginResponse = BeanUtil.copyProperties(user, UserLoginResponse.class);

        userLoginResponse.setToken(token);
        //缓存
        userCache.put(user.getId(),user);

        return userLoginResponse;
    }


}



