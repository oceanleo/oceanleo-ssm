package com.oceanleo.project.ssm.service;

import com.oceanleo.project.ssm.dto.MenuDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haiyang.li on 2017/9/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring/*.xml"})
public class MenuServiceTest {

    @Resource
    private MenuService menuService;

    @Test
    public void testGetMenu(){
        List<MenuDto> menuDtoList = menuService.getByUserId("3");
        for (MenuDto menuDto:menuDtoList) {
            System.out.println(menuDto);
        }
    }
}
