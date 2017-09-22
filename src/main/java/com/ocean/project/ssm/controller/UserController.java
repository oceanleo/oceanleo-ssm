package com.ocean.project.ssm.controller;

import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.service.MenuService;
import com.ocean.project.ssm.service.UserService;
import com.ocean.project.ssm.support.mvc.annotation.NotUseResult;
import com.ocean.project.ssm.support.mvc.controller.BaseController;
import com.ocean.project.ssm.support.orm.page.PageList;
import com.ocean.project.ssm.support.utils.DateUtils;
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
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;

    @RequestMapping("/getById")
    @ResponseBody
    public Object getById(String id){
        System.out.println(DateUtils.format(new Date())+" current user id : " +getUserId());
        System.out.println(DateUtils.format(new Date())+" currentThread name : "+Thread.currentThread().getName());
        User user = userService.getById(id);
        return user;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Object getAll(UserQuery query){
        System.out.println(DateUtils.format(new Date()) + " getAll before : "+Thread.currentThread().getName());
        List<User> userList = userService.getAll(query);
        System.out.println(DateUtils.format(new Date()) + " getAll after : "+Thread.currentThread().getName());
        return userList;
    }

    @RequestMapping("/getAllMenu")
    @ResponseBody
    @NotUseResult
    public Object getAllMenu(){
        List<MenuDto> menuDtoList = menuService.findAllMenu();
        return menuDtoList;
    }
}
