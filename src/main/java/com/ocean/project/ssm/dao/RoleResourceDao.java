package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.po.RoleResource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface RoleResourceDao {

    void insert(RoleResource roleResource);

    List<RoleResource> selectAll();
}
