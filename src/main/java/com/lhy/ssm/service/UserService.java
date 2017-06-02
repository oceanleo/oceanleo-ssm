package com.lhy.ssm.service;

import com.lhy.ssm.po.User;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface UserService {

    User getById(String id);

    void update(List<User> userList);

    void insert(User user);

    List<User> getAll();
}
