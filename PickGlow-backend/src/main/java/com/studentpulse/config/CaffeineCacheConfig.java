package com.studentpulse.config;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * CaffeineCache配置相关类
 */

@Configuration
public class CaffeineCacheConfig {


    /**
     * 用户在线信息缓存
     * @return
     */
    @Bean
    public Cache<Long, Object> userCache() {
         return  Caffeine.newBuilder()
                .maximumSize(1000)   //最大缓存数量
                .expireAfterWrite(30, TimeUnit.MINUTES) // 写入后 30 分钟过期
                .build();
    }
}
