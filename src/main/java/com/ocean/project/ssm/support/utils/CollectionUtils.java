package com.ocean.project.ssm.support.utils;

import java.util.Collection;

/**
 * 集合处理工具类
 *
 * @author haiyang.li on 2017/8/25.
 */
public abstract class CollectionUtils {

    /**
     * 判断集合是否为空 排除 null
     *
     * @param collection 集合
     * @return
     */
    public static boolean isEmpty(Collection collection){
        if(collection == null){
            throw new NullPointerException("collection is not allow null");
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
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection collection){
        if(collection == null){
            throw new NullPointerException("collection is not allow null");
        }
        for(Object object : collection){
            if(object != null){
                return true;
            }
        }
        return false;
    }
}
