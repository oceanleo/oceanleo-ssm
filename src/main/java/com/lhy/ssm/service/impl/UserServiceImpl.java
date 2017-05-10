package com.lhy.ssm.service.impl;

import com.lhy.ssm.dao.UserDao;
import com.lhy.ssm.po.User;
import com.lhy.ssm.service.UserService;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getById(String id) {
        System.out.println("UserService:   "+userDao);
        return userDao.selectById(id);
    }
}
