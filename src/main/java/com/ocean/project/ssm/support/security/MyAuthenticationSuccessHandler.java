package com.ocean.project.ssm.support.security;

import com.ocean.project.ssm.support.utils.DateUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 登录成功控制器
 *
 * @author haiyang.li on 2017/7/11.
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {


        System.out.println(DateUtils.format(new Date()) + " 登录成功 跳转到主界面");
        response.sendRedirect(request.getContextPath() + "/");
    }
}
