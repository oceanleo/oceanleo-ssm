package com.oceanleo.project.ssm.service;

import com.oceanleo.project.ssm.domain.User;
import com.oceanleo.project.ssm.query.UserQuery;
import com.oceanleo.project.ssm.support.log.AppLog;
import com.oceanleo.project.ssm.support.security.po.CurrentUser;

import java.util.List;

/**
 * @author haiyang.li
 */
@AppLog("用户业务层")
public interface UserService {

    @AppLog("通过id获取用户")
    User getById(String id);

    @AppLog("批量修改用户信息")
    void update(List<User> userList);

    @AppLog("新增用户")
    void create(User user);

    @AppLog("获取用户列表")
    List<User> getAll(UserQuery query);

    @AppLog("修改当前用户密码")
    void updatePassword(CurrentUser currentUser, String oldPassword, String newPassword);
}