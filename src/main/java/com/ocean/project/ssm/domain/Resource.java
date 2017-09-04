package com.ocean.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class Resource extends Domain implements Serializable {

    private static final long serialVersionUID = 8587256783646042277L;
    //资源名称
    private String resourceName;
    //资源类型
    private String resourceType;
    //资源url
    private String resourceString;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceName='" + resourceName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceString='" + resourceString + '\'' +
                '}';
    }
}
