package com.lhy.ssm.dao;

import com.lhy.ssm.po.RoleResource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface RoleResourceDao {

    void insert(RoleResource roleResource);

    List<RoleResource> selectAll();
}
