package com.oceanleo.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class MenuResource extends Domain implements Serializable {

    private static final long serialVersionUID = -8858332840490606429L;

    private String menuId;          //菜单Id

    private String resourceId;      //资源id

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
