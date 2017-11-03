package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.UserDao;
import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.service.UserService;
import com.ocean.project.ssm.support.core.exception.BizException;
import com.ocean.project.ssm.support.security.po.CurrentUser;
import com.ocean.project.ssm.support.utils.StringUtils;

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

    @Override
    public void updatePassword(CurrentUser currentUser, String oldPassword, String newPassword) {
        if (!StringUtils.hasText(oldPassword) || !StringUtils.hasText(newPassword)) {
            throw new BizException("密码不能为空");
        }
        if (oldPassword.equals(newPassword)) {
            throw new BizException("新旧密码不能相同");
        }
        User user = userDao.selectById(currentUser.getId());
        if (!user.getPassword().equals(oldPassword)) {
            throw new BizException("旧密码不正确");
        }
        userDao.updatePassword(currentUser.getId(), newPassword);
    }
}
