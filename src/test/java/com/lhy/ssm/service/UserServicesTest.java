package com.lhy.ssm.service;

import com.lhy.ssm.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:config/spring/*.xml"})
public class UserServicesTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetUserById(){
        User user = userService.getById("1");
        System.out.println(user);
    }
}
