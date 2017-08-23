package com.ocean.project.ssm.service;

import com.ocean.project.ssm.po.User;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface UserService {

    User getById(String id);

    void update(List<User> userList);

    void create(User user);

    List<User> getAll();
}
