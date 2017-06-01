package com.lhy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haiyang.li
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/in")
    public String loginIn(){


        return "/login";
    }
}
