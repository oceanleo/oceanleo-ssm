package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author haiyang.li on 2017/9/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring/*.xml"})
public class RoleServiceTest {

    @Resource
    private RoleService roleService;

    @Test
    public void testInsertRole(){
//        for(int i = 0;i<=100;i++){
//            Role role = new Role();
//            role.setRoleName("角色名称"+i);
//            role.setRoleCode("ROLE_CODE_"+i);
//            roleService.create(role);
//        }
    }
}
