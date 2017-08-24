package com.ocean.project.ssm.service;

import com.ocean.project.ssm.dao.ResourceDao;
import com.ocean.project.ssm.dao.RoleResourceDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author haiyang.li
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/*.xml"})
public class UserServicesTest {

    @Resource
    private UserService userService;
    @Resource
    private ResourceDao resourceDao;
    @Resource
    private RoleResourceDao roleResourceDao;

    @Test
    public void testGetUserById(){
        try {
//            List l = new ArrayList<Number>();
//            List<String> ls = l;
//            l.add(0, new Integer(42));
//            String s = ls.get(0);
//            System.out.println(s);
//            String className = "ResultCode";
//            Class<Enum> clazz = (Class<Enum>) Class.forName(className);
//            List<EnumObj> enumObjList = getEnumList(className);
//            for(EnumObj enumObj : enumObjList){
//                System.out.println(enumObj.toString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<EnumObj> getEnumList(String classPathName){
        try{
            Class<Enum> c = (Class<Enum>)Class.forName(classPathName);
            Enum[] enums = c.getEnumConstants();
            Field[] fields = c.getDeclaredFields();
            StringBuilder methodName;
            if(fields.length == 0){
                throw new RuntimeException("sorry,the class have not fields!");
            }else{
                methodName = new StringBuilder("get");
                for(Field field:fields){
                    if(!field.isEnumConstant()){
                        String firstBigStr = getFirstBigString(field.getName());
                        methodName.append(firstBigStr);
                    }
                    if(methodName.length() > 3){
                        break;
                    }
                }
            }
            if(methodName.length() == 3){
                throw new RuntimeException("when use EnumUtils.findEnumList ,enum must have description!");
            }
            List<EnumObj> list = new LinkedList<EnumObj>();
            for(Enum obj:enums){
                list.add(new EnumObj(obj.name(), getEnumDescription(obj, methodName.toString())));
            }
            return list;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    public static class EnumObj{
        /**
         * 枚举名称
         */
        private String name;
        /**
         * 枚举描述
         */
        private String description;

        public EnumObj(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {

            return description;
        }

        @Override
        public String toString() {
            return "EnumObj{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
    /**
     * 获取描述内容
     *
     * */
    private static String getEnumDescription(Enum obj, String methodName){
        try{
            Method method = obj.getClass().getMethod(methodName);
            return method.invoke(obj).toString();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    private static String getFirstBigString(String val){
        if(StringUtils.hasText(val)){
            return val.substring(0, 1).toUpperCase() + val.substring(1, val.length());
        }else{
            return "";
        }
    }

    @Test
    public void testInsertUser(){
//        User user = new User();
//        user.setUsername("lhy");
//        user.setPassword("lhy");
//        userService.create(user);
    }

    static int a = 0;

    public static void main(String args[]) throws Exception {
//        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("G:/1.txt"));
//        outputStream.write("李海洋输出流测试".getBytes("UTF-8"));
//        outputStream.flush();
//        outputStream.close();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a++;
                if(a==5){
                    timer.cancel();
                }
                System.out.println(a);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        }, 1000,3000);
        System.out.println("------");
    }
}
