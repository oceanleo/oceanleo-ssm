package com.oceanleo.project.ssm.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制层
 *
 * @author haiyang.li
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/in")
    public String loginIn() {

        return "/login";
    }
}
