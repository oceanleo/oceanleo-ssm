package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.RoleDao;
import com.ocean.project.ssm.domain.Role;
import com.ocean.project.ssm.service.RoleService;
import com.ocean.project.ssm.support.orm.datasource.DataSourceContextHolder;
import com.ocean.project.ssm.support.orm.query.PageQuery;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haiyang.li on 2017/9/24.
 */
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> getPageList(PageQuery query) {
        return roleDao.selectPageList(query);
    }

    @Override
    public void create(Role role) {
        roleDao.insert(role);
    }
}
