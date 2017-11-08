package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.domain.MenuResource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface MenuResourceDao {

    void insert(MenuResource roleResource);

    List<MenuResource> selectAll();
}
