package com.lhy.ssm.po;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class Resource extends Domain implements Serializable {

    private static final long serialVersionUID = 8587256783646042277L;
    //
    private String resourceName;
    //
    private String resourceType;
    //
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
