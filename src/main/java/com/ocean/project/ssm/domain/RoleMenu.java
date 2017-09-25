package com.ocean.project.ssm.domain;

import java.io.Serializable;

/**
 * 角色与菜单
 *
 * @author haiyang.li on 2017/9/25.
 */
public class RoleMenu extends Domain implements Serializable {

    private static final long serialVersionUID = 3887038586093259874L;
    //角色id
    private String roleId;
    //菜单id
    private String menuId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
