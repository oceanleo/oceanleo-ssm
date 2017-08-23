package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.UserDao;
import com.ocean.project.ssm.po.User;
import com.ocean.project.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haiyang.li
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getById(String id) {
//        throw new BizException("获取失败！！");
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
    public List<User> getAll() {
        return userDao.selectAll();
    }
}
