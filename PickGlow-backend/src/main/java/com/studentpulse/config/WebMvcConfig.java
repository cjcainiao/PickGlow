package com.studentpulse.config;

import com.studentpulse.Interceptor.UserRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 用户请求拦截器
         */
        registry.addInterceptor(new UserRequestInterceptor())
                .addPathPatterns("/user/**")
                .addPathPatterns("/admin/**")
                .excludePathPatterns(
                        "/user/login",
                        "/user/register"
                );
    }
}
