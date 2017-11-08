package com.oceanleo.project.ssm.support.utils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 对象处理工具类
 *
 * @author haiyang.li on 2017/8/27.
 */
public abstract class BeanUtils {

    //序列化字段名称
    private static final String SERIAL_VERSION_UID = "serialVersionUID";

    /**
     * 对象的属性值的拷贝
     *
     * @param source 来源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        if (source != null && target != null) {
            //通过反射获取class
            Class sourceClass = source.getClass();
            Class targetClass = target.getClass();
            //获取类的字段
            Field[] sourceFields = sourceClass.getDeclaredFields();
            Field[] targetFields = targetClass.getDeclaredFields();
            //判断字段是否相同,字段值是否为null
            for (Field sourceField : sourceFields) {
                for (Field targetField : targetFields) {
                    try {
                        //字段不为序列化字段
                        if (!sourceField.getName().equals(SERIAL_VERSION_UID)) {
                            sourceField.setAccessible(true);
                            //字段有值
                            if (sourceField.get(source) != null) {
                                //字段名称相同
                                if (sourceField.getName().equals(targetField.getName())) {
                                    //字段类型相同
                                    if (sourceField.getType().equals(targetField.getType())) {
                                        targetField.setAccessible(true);
                                        targetField.set(target, sourceField.get(source));
                                        break;
                                    } else {
                                        throw new IllegalArgumentException(sourceClass.getSimpleName() + "和" + targetClass.getSimpleName() + "类的" + sourceField.getName() + "字段类型不一致");
                                    }
                                }
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 对目标对象，设置指定字段的值
     *
     * @param target     目标对象
     * @param fieldName  字段名称
     * @param fieldValue 字段值
     * @return 字段的值
     */
    public static void setFieldValue(Object target, String fieldName, Object fieldValue) {
        Field field = getField(target, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(target,fieldValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取目标对象，指定字段的值
     *
     * @param target    目标对象
     * @param fieldName 字段名称
     * @return 字段的值
     */
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

    /**
     * 获取目标对象，指定字段
     *
     * @param target    目标对象
     * @param fieldName 字段名称
     * @return 字段对象
     */
    public static Field getField(Object target, String fieldName) {
        AssertUtils.isNotNull(target, "目标不能为空");
        AssertUtils.hasText(fieldName, "字段名称不能为空");
        Class clazz = target.getClass();
        //循环遍历，获取字段值
        while (!clazz.equals(Object.class)){
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                //子类没有就查找父类
                clazz = clazz.getSuperclass();
                System.out.println(DateUtils.format(new Date()) + " 获取字段值失败 target:"+target.getClass()+" fieldName:"+fieldName);
            }
        }
        return null;
    }
}
