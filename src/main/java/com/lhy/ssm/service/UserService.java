package com.lhy.ssm.service;

import com.lhy.ssm.dao.UserDao;
import com.lhy.ssm.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
@Service
public interface UserService {

    User getUserById(String id);
}
