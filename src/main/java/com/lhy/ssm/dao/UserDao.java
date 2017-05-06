package com.lhy.ssm.dao;

import com.lhy.ssm.po.User;
import org.springframework.stereotype.Repository;

/**
 * @author haiyang.li
 */
@Repository
public interface UserDao {

    User selectById(String id);
}
