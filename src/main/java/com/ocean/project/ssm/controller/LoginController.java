package com.ocean.project.ssm.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haiyang.li
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/in")
    public String loginIn() {

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails) principal).getUsername();
//            System.out.println(username);
//        } else {
//            String username = principal.toString();
//            System.out.println(username);
//        }
        return "/login";
    }
}
