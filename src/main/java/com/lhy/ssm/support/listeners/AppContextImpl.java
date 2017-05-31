package com.lhy.ssm.support.listeners;

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
    public String getConfigByKey(String keyName) {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("AppContextImpl---销毁---");
    }
}
