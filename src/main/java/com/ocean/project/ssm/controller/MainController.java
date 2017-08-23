package com.ocean.project.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haiyang.li
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/main")
    public String main(){
        return "/main";
    }
}
