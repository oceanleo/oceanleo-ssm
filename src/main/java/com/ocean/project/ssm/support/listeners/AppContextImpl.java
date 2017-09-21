package com.ocean.project.ssm.support.listeners;

import com.ocean.project.ssm.support.utils.StringUtils;

import java.util.Properties;

/**
 * @author haiyang.li
 */
public class AppContextImpl implements AppContext{

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void init() {
        System.out.println("AppContextImpl---初始化---");
    }

    @Override
    public String getConfigByKey(String key) {
        String value = properties.getProperty(key);
        if(StringUtils.hasText(value)){
            return value;
        }
        throw new AppContextException("properties value is not exist : "+key);
    }

    @Override
    public void destroy() {
        System.out.println("AppContextImpl---销毁---");
    }
}
