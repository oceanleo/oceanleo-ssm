package com.oceanleo.project.ssm.controller;

import com.oceanleo.project.ssm.domain.User;
import com.oceanleo.project.ssm.query.UserQuery;
import com.oceanleo.project.ssm.service.UserService;
import com.oceanleo.project.ssm.support.mvc.controller.BaseController;
import com.oceanleo.project.ssm.support.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户控制层
 *
 * @author haiyang.li
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getAll(UserQuery query) {
        System.out.println(DateUtils.format(new Date()) + " getAll before : " + Thread.currentThread().getName());
        List<User> userList = userService.getAll(query);
        System.out.println(DateUtils.format(new Date()) + " getAll after : " + Thread.currentThread().getName());
        return userList;
    }

    @RequestMapping("/update/password")
    @ResponseBody
    public Object updatePassword(String oldPassword, String newPassword) {
        userService.updatePassword(getUserInfo(), oldPassword, newPassword);
        return "修改成功";
    }
}
