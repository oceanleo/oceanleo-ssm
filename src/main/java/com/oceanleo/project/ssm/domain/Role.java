package com.oceanleo.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class Role extends Domain implements Serializable {

    private static final long serialVersionUID = -5165868335479846915L;

    private String roleName;        //角色名称

    private String roleCode;        //角色编码

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
