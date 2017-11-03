package com.ocean.project.ssm.support.security.po;

/**
 * 需要获取的当前用户信息
 *
 * @author haiyang.li 2017/7/21.
 */
public abstract class CurrentUser {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getUsername();
}
