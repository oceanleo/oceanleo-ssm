package com.lhy.ssm.controller;

import com.lhy.ssm.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    public Object getById(String id){
        return userService.getById(id);
    }
}
