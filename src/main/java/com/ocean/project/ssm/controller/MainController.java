package com.ocean.project.ssm.controller;

import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.service.MenuService;
import com.ocean.project.ssm.service.UserService;
import com.ocean.project.ssm.support.mvc.annotation.NotUseResult;
import com.ocean.project.ssm.support.mvc.controller.BaseController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
