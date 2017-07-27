package com.lhy.ssm.support.intercept;

import com.lhy.ssm.dao.RoleDao;
import com.lhy.ssm.dao.UserDao;
import com.lhy.ssm.po.Role;
import com.lhy.ssm.po.User;
import com.lhy.ssm.support.utils.AssertUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义用户登录判断
 *
 * @author haiyang.li on 2017/7/11.
 */
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AssertUtils.hasText(username, "用户名不能为空");
        //获取用户
        User user = userDao.selectByUsername(username);
        AssertUtils.isNotNull(user, "用户不存在！");
        // 密码
        String password = user.getPassword();
        // 帐户是否可用
        boolean enabled = user.isEnabled();
        //设置角色
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
        //封装角色对象到当前用户
        List<Role> roleList;
        if (user.isRoot()) {
            roleList = roleDao.selectAll();
        } else {
            roleList = roleDao.selectByUsername(username);
        }
        for (Role role : roleList) {
            //设置角色编码
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleCode());
            grantedAuthoritySet.add(authority);
        }
        return new UserInfo(username, password, enabled, grantedAuthoritySet, user);
    }
}
