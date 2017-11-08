package com.oceanleo.project.ssm.controller;

import com.oceanleo.project.ssm.domain.User;
import com.oceanleo.project.ssm.service.MenuService;
import com.oceanleo.project.ssm.service.UserService;
import com.oceanleo.project.ssm.support.mvc.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 主控制层
 *
 * @author haiyang.li
 */
@Controller
public class MainController extends BaseController {

    @Resource
    private MenuService menuService;
    @Resource
    private UserService userService;

    /**
     * 应用程序入口
     */
    @RequestMapping("/")
    public String main(Model model) {
        String userId = getUserId();
        User user = userService.getById(userId);
        String viewName = "/main";
        model.addAttribute("user",user);
        return viewName;
    }

    /**
     * 获取菜单
     */
    @RequestMapping("/sys/menu")
    @ResponseBody
    public Object menu() {
        String userId = getUserId();
        return menuService.getByUserId(userId);
    }
}
