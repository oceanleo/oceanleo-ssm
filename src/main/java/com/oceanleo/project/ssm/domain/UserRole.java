package com.oceanleo.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class UserRole extends Domain implements Serializable {

    private static final long serialVersionUID = 4830830634828979462L;

    private String userId;      //用户id

    private String roleId;      //角色id

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
