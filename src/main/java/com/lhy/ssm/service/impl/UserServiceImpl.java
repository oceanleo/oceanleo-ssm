package com.lhy.ssm.service.impl;

import com.lhy.ssm.dao.UserDao;
import com.lhy.ssm.po.User;
import com.lhy.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getById(String id) {
        return userDao.selectById(id);
    }
}
