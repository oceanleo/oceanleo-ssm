package com.lhy.ssm.support.utils;

import com.lhy.ssm.support.BizException;

/**
 * @author haiyang.li 2017/7/20.
 */
public class AssertUtils {

    public static void hasText(String text,String message){
       if(!StringUtils.hasText(text)){
           throw new BizException(message);
       }
    }

    public static void isNotNull(Object obj,String message){
       if(obj == null){
           throw new BizException(message);
       }
    }
}
