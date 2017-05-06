package com.lhy.ssm.controller;

import com.lhy.ssm.po.User;
import com.lhy.ssm.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
public class UserController {

    private UserService userService;

    public User getUserById(){
        System.out.println(userService.getClass());
        return  userService.getUserById("1");
    }
}
