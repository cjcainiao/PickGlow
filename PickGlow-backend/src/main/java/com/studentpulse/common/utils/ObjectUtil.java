package com.studentpulse.common.utils;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 对象相关的工具类
 */
@Slf4j
public class ObjectUtil {

    private ObjectUtil() {
    }

    ;

    /**
     * 判断对象属性是否有空值
     *
     * @param obj
     * @return
     */
    public static boolean AttributeHasNull(Object obj) {

        if (obj == null) return true;

        //获取对象的所有字段
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);  //暴力反射
            Object o = null;
            try {
                o = field.get(obj);
            } catch (IllegalAccessException e) {
                log.error("对象参数判断空值出错");
                throw new RuntimeException(e);
            }
            if (o == null || o == "") return true;
        }
        return false;
    }
}
