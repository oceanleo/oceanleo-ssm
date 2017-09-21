package com.ocean.project.ssm.support.utils;

import java.util.Collection;

/**
 * @author haiyang.li on 2017/8/27.
 */
public abstract class CollectionUtils {

    /**
     * 判断集合是否为空 排除 null
     */
    public static boolean isEmpty(Collection collection){
        if(collection == null){
            throw new NullPointerException("集合为空");
        }
        for(Object object : collection){
            if(object != null){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断集合是否不为空 排除null
     */
    public static boolean isNotEmpty(Collection collection){
        if(collection == null){
            throw new NullPointerException("集合为空");
        }
        for(Object object : collection){
            if(object != null){
                return true;
            }
        }
        return false;
    }
}
