package com.oceanleo.project.ssm.dto;

/**
 * @author haiyang.li
 */
public class ResourceDto {


    private String roleCode;            //角色编码

    private String resourceString;      //权限url

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
