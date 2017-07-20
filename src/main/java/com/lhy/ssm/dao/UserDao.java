package com.lhy.ssm.dao;

import com.lhy.ssm.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface UserDao {

    /**
     * 根据用户id获取用户
     */
    User selectById(@Param("id") String id);

    /**
     * 修改用户信息
     */
    void update(@Param("userList") List<User> userList);

    /**
     * 添加用户
     */
    void insert(User user);

    /**
     * 获取所有的用户
     */
    List<User> selectAll();

    /**
     * 用户名获取用户信息
     */
    User selectByUsername(String username);
}
