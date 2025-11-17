package com.studentpulse.common.utils;


import org.mindrot.jbcrypt.BCrypt;

/**
 * 密码加密相关工具
 */
public class PasswordUtil {
    private PasswordUtil(){};

    /**
     *加密函数
     * @param rawPassword
     * @return
     */
    public static String Encrypt(String rawPassword){
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }


    /**
     * 校验密码
     * @param rawPassword 原始密码
     * @param encryptedPassword 加密之后的密码
     * @return
     */
    public static boolean checkPassword(String rawPassword,String encryptedPassword){
        return BCrypt.checkpw(rawPassword, encryptedPassword);
    }
}
