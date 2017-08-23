package com.ocean.project.ssm.po;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class RoleResource extends Domain implements Serializable {

    private static final long serialVersionUID = -8858332840490606429L;
    //角色Id
    private String roleId;
    //资源id
    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleResource{" +
                "resourceId='" + resourceId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
