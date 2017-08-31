package com.ocean.project.ssm.service;

import com.ocean.project.ssm.po.User;
import com.ocean.project.ssm.support.log.Log;

import java.util.List;

/**
 * @author haiyang.li
 */
@Log("用户业务层")
public interface UserService {

    @Log("获取用户id")
    User getById(String id);

    void update(List<User> userList);

    @Log("新增用户")
    void create(User user);

    List<User> getAll();
}
