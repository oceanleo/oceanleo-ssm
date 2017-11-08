package com.oceanleo.project.ssm.service.impl;

import com.oceanleo.project.ssm.dao.RoleDao;
import com.oceanleo.project.ssm.domain.Role;
import com.oceanleo.project.ssm.service.RoleService;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

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
