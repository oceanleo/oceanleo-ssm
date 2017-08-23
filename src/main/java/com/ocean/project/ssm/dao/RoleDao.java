package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.po.Role;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface RoleDao {

    void insert(Role role);

    /**
     * 获取用户名所拥有的角色
     */
    List<Role> selectByUsername(String username);

    /**
     * 获取所有的角色
     */
    List<Role> selectAll();
}
