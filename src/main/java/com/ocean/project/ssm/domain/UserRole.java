package com.ocean.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class UserRole extends Domain implements Serializable {

    private static final long serialVersionUID = 4830830634828979462L;
    //用户id
    private String userId;
    //角色id
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
