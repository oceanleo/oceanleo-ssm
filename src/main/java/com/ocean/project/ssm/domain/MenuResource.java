package com.ocean.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class MenuResource extends Domain implements Serializable {

    private static final long serialVersionUID = -8858332840490606429L;
    //角色Id
    private String menuId;
    //资源id
    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "MenuResource{" +
                "menuId='" + menuId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
