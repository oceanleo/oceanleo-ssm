package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.domain.MenuResource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface MenuResourceDao {

    void insert(MenuResource roleResource);

    List<MenuResource> selectAll();
}
