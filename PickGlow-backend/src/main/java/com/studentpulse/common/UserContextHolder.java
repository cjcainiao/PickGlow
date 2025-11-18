package com.studentpulse.common;


import com.studentpulse.model.entity.User;

public class UserContextHolder {
    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 存入用户信息
     * @param user
     */
    public static void set(User user){
        USER_THREAD_LOCAL.set(user);
    }

    /**
     * 获取当前线程的用户信息
     * @return
     */
    public static User get(){
        return USER_THREAD_LOCAL.get();
    }

    /**
     * 移除用户信息
     */
    public static void clear(){
        USER_THREAD_LOCAL.remove();
    }
}
