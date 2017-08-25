package com.ocean.project.ssm.po;

import java.io.Serializable;

/**
 * @author haiyang.li on 2017/8/25.
 */
public class Menu extends Domain implements Serializable {

    private static final long serialVersionUID = 5089362992086561588L;
    //菜单名称
    private String name;
    //菜单编码
    private String code;
    //菜单url
    private String url;
    //排序
    private Integer sort;
    //上级菜单id
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
