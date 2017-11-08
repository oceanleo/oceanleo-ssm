package com.oceanleo.project.ssm.support.security.login;

import com.oceanleo.project.ssm.support.utils.DateUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 退出成功 处理器
 *
 * @author haiyang.li 2017/7/20.
 */
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println(DateUtils.format(new Date()) + " 退出成功,跳转到登录页面");
//        response.sendRedirect("/login/in");
        response.sendRedirect(request.getContextPath() + "/login/in");
        super.onLogoutSuccess(request, response, authentication);
    }
}
