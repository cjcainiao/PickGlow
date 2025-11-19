package com.studentpulse.aspect;


import com.studentpulse.Annotation.Administrator;
import com.studentpulse.common.UserContextHolder;
import com.studentpulse.exception.BaseException;
import com.studentpulse.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 检验是否是管理员权限
 */
@Slf4j
@Aspect
@Component
public class AdministratorAspect {

    /**
     * 校验Controller层方法上是否有Administrator注解
     */
    @Pointcut("execution(* com.studentpulse.controller..*(..))")
    public void AdminPointcut(){};

    @Around("AdminPointcut()")
    public Object checkAdmin(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("开始检查是否是管理员权限...");
        //1、获取当前方法上是否有注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Administrator annotation = method.getAnnotation(Administrator.class);
        if(annotation != null){
            //检验是否有有管理员权限
            User user = UserContextHolder.get();
            if(!user.getRole().equals("admin")){
                throw new BaseException(400,"无权限！");
            }
        }
        return joinPoint.proceed();
    }
}
