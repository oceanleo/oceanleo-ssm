package com.lhy.ssm.support.utils;

/**
 * @author haiyang.li
 */
public class StringUtils {

    public static final String EMPTY = "";

    public static boolean hasText(String str){
        return org.springframework.util.StringUtils.hasText(str);
    }
}
