package com.lhy.ssm.support.intercepter;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 自定义用户登录判断
 *
 * @author haiyang.li on 2017/7/11.
 */
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("My---UserDetails---Service---");
        return null;
    }
}
