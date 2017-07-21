package com.lhy.ssm.service.impl;

import com.lhy.ssm.dao.UserDao;
import com.lhy.ssm.po.User;
import com.lhy.ssm.service.UserService;
import com.lhy.ssm.support.BizException;
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
