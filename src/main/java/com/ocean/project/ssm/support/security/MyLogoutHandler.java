package com.ocean.project.ssm.support.security;

import com.ocean.framework.utils.DateUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 退出控制器
 *
 * @author haiyang.li 2017/7/20.
 */
public class MyLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println(DateUtils.format(new Date()) + " My Logout Handler-----");
    }
}
