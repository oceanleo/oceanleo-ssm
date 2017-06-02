package com.lhy.ssm.service;

import com.lhy.ssm.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author haiyang.li
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/*.xml"})
public class UserServicesTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetUserById(){
        List<User> userList = userService.getAll();
        for(User user : userList){
            System.out.println(user);
        }
    }
}
