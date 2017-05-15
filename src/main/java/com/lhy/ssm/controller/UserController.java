package com.lhy.ssm.controller;

import com.lhy.ssm.po.User;
import com.lhy.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public Object getById(String id,Model model){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/user/user";
    }
}
