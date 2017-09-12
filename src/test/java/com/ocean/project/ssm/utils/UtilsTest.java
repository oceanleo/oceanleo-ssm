package com.ocean.project.ssm.utils;

import com.ocean.framework.utils.AssertUtils;
import com.ocean.framework.utils.BeanUtils;
import com.ocean.framework.utils.DateUtils;
import com.ocean.project.ssm.query.UserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author haiyang.li on 2017/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring/*.xml"})
public class UtilsTest {

    @Test
    public void testBean() {
        Map<String, Object> map = new HashMap<String, Object>();
        UserQuery userQuery = new UserQuery();
        List<Field> fieldList = new ArrayList<Field>();
        Class clazz = userQuery.getClass();
        do {
            Field[] declaredFields = clazz.getDeclaredFields();
            fieldList.addAll(Arrays.asList(declaredFields));
            clazz = clazz.getSuperclass();
        } while (!clazz.equals(Object.class));
        for (Field field : fieldList) {
            String fieldName = field.getName();
            map.put(fieldName, getFieldValue(userQuery, fieldName));
        }
    }

    public static Object getFieldValue(Object target, String fieldName) {
        Field field = getField(target, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                return field.get(target);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Field getField(Object target, String fieldName) {
        AssertUtils.isNotNull(target, "目标不能为空");
        AssertUtils.hasText(fieldName, "字段名称不能为空");
        Class clazz = target.getClass();
        while (!clazz.equals(Object.class)) {
            try {
                System.out.println(DateUtils.format(new Date()) + " target:" + target.getClass() + " fieldName:" + fieldName);
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
                System.out.println(DateUtils.format(new Date()) + " 获取字段值 target:" + target.getClass() + " fieldName:" + fieldName);
            }
        }
        return null;
    }
}
