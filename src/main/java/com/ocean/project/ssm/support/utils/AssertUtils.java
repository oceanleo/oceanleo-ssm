package com.ocean.project.ssm.support.utils;

/**
 * @author haiyang.li on 2017/8/27.
 */
public class AssertUtils {

    public static void hasText(String text,String message){
        if(!StringUtils.hasText(text)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotNull(Object obj,String message){
        if(obj == null){
            throw new IllegalArgumentException(message);
        }
    }
}
