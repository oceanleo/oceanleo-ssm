package com.ocean.project.ssm.controller;

import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.service.MenuService;
import com.ocean.project.ssm.support.mvc.annotation.NotUseResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haiyang.li
 */
@Controller
public class MainController {

    @Resource
    private MenuService menuService;

    @RequestMapping("/main")
    public String main() {
        return "/main";
    }

    @RequestMapping("/menu")
    @ResponseBody
    @NotUseResult
    public Object getAllMenu() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            System.out.println(username);
        } else {
            String username = principal.toString();
            System.out.println(username);
        }
        List<MenuDto> menuDtoList = menuService.findAllMenu();
        return menuDtoList;
    }
}
