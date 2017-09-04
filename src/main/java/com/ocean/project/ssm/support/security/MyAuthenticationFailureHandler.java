package com.ocean.project.ssm.support.security;

import com.ocean.framework.utils.DateUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 登录失败控制器
 *
 * @author haiyang.li on 2017/7/11.
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        System.out.println(DateUtils.format(new Date()) + " My---Authentication---Failure---Handler---");
        response.sendRedirect(request.getContextPath() + "/login/in");
    }
}
