package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.UserDao;
import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.service.UserService;
import com.ocean.project.ssm.support.core.exception.BizException;
import com.ocean.project.ssm.support.orm.datasource.DataSourceContextHolder;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haiyang.li
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getById(String id) {
        return userDao.selectById(id);
    }

    @Override
    public void update(List<User> userList) {
        userDao.updateList(userList);
    }

    @Override
    public void create(User user) {
        userDao.insert(user);
    }

    @Override
    public List<User> getAll(UserQuery query) {
        return userDao.selectAll(query);
    }
}
