package com.studentpulse.Annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自己定义注解，实现在运行方法之前检查请求参数是否包含空值
 */
@Retention(RetentionPolicy.RUNTIME) //保留到运行时
@Target(ElementType.METHOD)  //只能作用于方法
public @interface ParameterHasNull {
}
