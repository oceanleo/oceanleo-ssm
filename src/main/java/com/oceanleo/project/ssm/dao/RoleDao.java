package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.domain.Role;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface RoleDao {

    void insert(Role role);

    List<Role> selectByUsername(String username);

    List<Role> selectAll();

    List<Role> selectPageList(PageQuery query);
}
