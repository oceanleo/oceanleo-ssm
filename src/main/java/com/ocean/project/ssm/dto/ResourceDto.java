package com.ocean.project.ssm.dto;

/**
 * @author haiyang.li
 */
public class ResourceDto {

    //角色编码
    private String roleCode;
    //权限url
    private String resourceString;

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
