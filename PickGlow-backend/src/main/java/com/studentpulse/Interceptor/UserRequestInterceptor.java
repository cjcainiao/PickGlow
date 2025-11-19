package com.studentpulse.Interceptor;

import com.studentpulse.common.UserContextHolder;
import com.studentpulse.common.utils.JwtUtil;
import com.studentpulse.exception.BaseException;
import com.studentpulse.model.entity.User;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户请求拦截器
 */
@Slf4j
public class UserRequestInterceptor implements HandlerInterceptor {


    /**
     * 获取当前用户的id
     *
     * @param request
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        log.info("拦截器开始...{}", token);
        if (token == "" || token == null) {
            throw new BaseException(400, "登录过期，请重新登录!");
        }
        Claims claims = JwtUtil.parsePayload(token);

        User user = new User();
        user.setId(claims.get("id", Long.class));
        user.setUserName(claims.get("name", String.class));
        user.setRole(claims.get("role", String.class));
        UserContextHolder.set(user);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserContextHolder.clear();
    }

}
