package com.studentpulse.common.utils;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * jwt相关工具
 */
public class JwtUtil {

    private JwtUtil(){};


    private final static int ACCESS_EXPIRE = 3600000; //过期时间

    private final static String SECRET = "1234567890312312312312312312312321312" ; //密钥

    public static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());


    /**
     * 创建token
     * @param mp
     * @return
     */
    public static String createToken(Map<String,Object> mp){

        return Jwts.builder()
                .claims(mp)  //设置负载信息
                .expiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRE)) //设置过期时间
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public static Jws<Claims> parseClaim(String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token);
    }


    /**
     * 获取载荷信息
     * @param token
     * @return
     */
    public static Claims parsePayload(String token) {
        return parseClaim(token).getPayload();
    }
}
