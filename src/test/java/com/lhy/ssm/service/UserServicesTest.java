package com.lhy.ssm.service;

import com.lhy.ssm.dao.ResourceDao;
import com.lhy.ssm.dao.RoleResourceDao;
import com.lhy.ssm.po.RoleResource;
import com.lhy.ssm.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author haiyang.li
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/*.xml"})
public class UserServicesTest {

    @Resource
    private UserService userService;
    @Resource
    private ResourceDao resourceDao;
    @Resource
    private RoleResourceDao roleResourceDao;

    @Test
    public void testGetUserById(){
        List<User> userList = userService.getAll();
        for(User user : userList){
            System.out.println(user);
        }
        List<com.lhy.ssm.po.Resource> resourceList = resourceDao.selectAll();
        for(com.lhy.ssm.po.Resource resource : resourceList){
            System.out.println(resource);
        }
        List<RoleResource> roleResourceList = roleResourceDao.selectAll();
        for(RoleResource roleResource : roleResourceList){
            System.out.println(roleResource);
        }
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("lhy");
        user.setPassword("lhy");
        userService.create(user);
    }

    public static void main(String args[]) throws Exception {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("G:/1.txt"));
        outputStream.write("李海洋输出流测试".getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
