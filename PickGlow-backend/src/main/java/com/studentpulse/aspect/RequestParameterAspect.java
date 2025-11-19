package com.studentpulse.aspect;


import com.studentpulse.Annotation.ParameterHasNull;
import com.studentpulse.common.Result;
import com.studentpulse.common.utils.ObjectUtil;
import com.studentpulse.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 判断指定方法上面有没有指定注解，然后执行某种方法
 */


@Aspect
@Component
@Slf4j
public class RequestParameterAspect {

    /**
     * 切入点，指定包下的所有方法
     */
    @Pointcut("execution(* com.studentpulse.service.Impl..*(..))")
    public void ParameterPointcut() {}


    /**
     * 在方法执行之前执行检查参数是否有空值
     */
    @Around("ParameterPointcut()")
    public Object checkParameter(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();  //拿到执行的方法对象

        ParameterHasNull annotation = method.getAnnotation(ParameterHasNull.class);

        boolean flgt = true;
        if(annotation != null) {  //包含ParameterHasNull注解才执行
            log.info("开始检查是否有空值....");
            //获取方法的参数
            Object[] args = joinPoint.getArgs();
            //检验参数是否有空值
            for (Object arg : args) {
                if(ObjectUtil.AttributeHasNull(arg)){
                    flgt = false; // 表示有空值
                    break;
                }
            }
        }

        if(flgt){
            return joinPoint.proceed();
        }
        else throw new BaseException("请求参数不能为空");

    }



}
