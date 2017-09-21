package com.ocean.project.ssm.controller;

import com.ocean.framework.mvc.annotation.NotUseResult;
import com.ocean.framework.orm.page.PageList;
import com.ocean.framework.utils.DateUtils;
import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haiyang.li
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getById")
    @ResponseBody
    public Object getById(UserQuery query){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            System.out.println(username);
        } else {
            String username = principal.toString();
            System.out.println(username);
        }
        System.out.println(Thread.currentThread().getName());
        User user = userService.getById(query);
        return user;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @NotUseResult
    public Object getAll(UserQuery query){
        System.out.println(DateUtils.format(new Date()) + " getAll before : "+Thread.currentThread().getName());
        List<User> userList = userService.getAll(query);
        System.out.println(DateUtils.format(new Date()) + " getAll after : "+Thread.currentThread().getName());
        if(userList instanceof PageList){
            PageList pageList = (PageList) userList;
            Map<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("list",pageList);
            resultMap.put("total",pageList.getTotal());
            return resultMap;
        }
        return userList;
    }
}
