package com.studentpulse.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 标记为仅管理员使用的方法
 */
@Retention(RetentionPolicy.RUNTIME) //保留到运行时
@Target(ElementType.METHOD)  //只能作用于方法
public @interface Administrator {
}
