package com.lhy.ssm.controller;

import com.lhy.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getById")
    public Object getById(String id){
        return userService.getById(id);
    }
}
