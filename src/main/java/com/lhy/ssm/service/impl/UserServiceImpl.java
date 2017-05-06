package com.lhy.ssm.service.impl;

import com.lhy.ssm.dao.UserDao;
import com.lhy.ssm.po.User;
import com.lhy.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */

public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(String id){
        System.out.println(id);
        return null;
    }
}
