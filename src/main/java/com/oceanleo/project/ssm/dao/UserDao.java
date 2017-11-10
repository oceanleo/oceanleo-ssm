package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.domain.User;
import com.oceanleo.project.ssm.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface UserDao {

    User selectById(String id);

    void updateList(@Param("userList") List<User> userList);

    void insert(User user);

    List<User> selectAll(UserQuery query);

    User selectByUsername(String username);

    void updatePassword(@Param("userId") String userId, @Param("newPassword") String newPassword);
}
