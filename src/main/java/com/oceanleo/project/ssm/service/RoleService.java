package com.oceanleo.project.ssm.service;

import com.oceanleo.project.ssm.domain.Role;
import com.oceanleo.project.ssm.support.log.AppLog;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * 角色业务层
 *
 * @author haiyang.li on 2017/9/24.
 */
@AppLog("角色业务层")
public interface RoleService {

    @AppLog("获取角色列表")
    List<Role> getPageList(PageQuery query);

    @AppLog("新增角色")
    void create(Role role);
}
