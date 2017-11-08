package com.oceanleo.project.ssm.utils;

import com.oceanleo.project.ssm.support.utils.AssertUtils;
import com.oceanleo.project.ssm.support.utils.DateUtils;
import com.oceanleo.project.ssm.support.utils.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedInputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.Date;

/**
 * @author haiyang.li on 2017/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring/*.xml"})
public class UtilsTest {

    @Test
    public void testClient() {
        try {
//            Socket socket = new Socket(InetAddress.getLocalHost(), 10086);
//            BufferedOutputStream stream = new BufferedOutputStream(socket.getOutputStream());
//
//            String h = "你好";
//            byte[] hs = h.getBytes("UTF-8");
//            System.out.println(DateUtils.formatCurrentTime()+" 发送消息成功,发送内容:"+h);
//            stream.write(hs);
//            stream.flush();
//
//            Thread.sleep(3000);
//
//            String send = "今天晚上约么?";
//            byte[] bytes = send.getBytes("UTF-8");
//            System.out.println(DateUtils.formatCurrentTime()+" 发送消息成功,发送内容:"+send);
//            stream.write(bytes);
//            stream.close();
//            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testService() {
//        ServerSocket serverSocket = null;
//        Socket client = null;
//        try {
//            serverSocket = new ServerSocket(10087);
//            client = serverSocket.accept();
//            while (true) {
//                receive(client);
//                Scanner scanner = new Scanner(System.in);
//                if(scanner.hasNext()){
//                    String t = scanner.nextLine();
//                    new ClientTest().send(t);
//                }
//                scanner.close();
//
//                client = serverSocket.accept();
//
//            }
//        } catch (Exception e) {
//
//        } finally {
//            if (serverSocket != null) {
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (client != null) {
//                try {
//                    client.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    public void receive(Socket client) throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(client.getInputStream());
        byte[] bytes = new byte[1024];
        int a = bufferedInputStream.read(bytes);
        while (a != -1) {
            String result = new String(bytes, "UTF-8").trim();
            System.out.println(DateUtils.formatCurrentTime() + " 接收消息成功,接收内容:" + result);
            a = bufferedInputStream.read(bytes);
        }
        bufferedInputStream.close();
    }

    public String byteTo16(byte bt) {
        String[] strHex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        String resStr = "";
        int low = (bt & 15);
        int high = bt >> 4 & 15;
        resStr = strHex[high] + strHex[low];
        return resStr;
    }

    @Test
    public void testBean() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        UserQuery userQuery = new UserQuery();
//        List<Field> fieldList = new ArrayList<Field>();
//        Class clazz = userQuery.getClass();
//        do {
//            Field[] declaredFields = clazz.getDeclaredFields();
//            fieldList.addAll(Arrays.asList(declaredFields));
//            clazz = clazz.getSuperclass();
//        } while (!clazz.equals(Object.class));
//        for (Field field : fieldList) {
//            String fieldName = field.getName();
//            map.put(fieldName, getFieldValue(userQuery, fieldName));
//        }
    }

    public String join(String sourcesStr, String addStr, int length) {
        if (StringUtils.hasText(sourcesStr)) {
            if (sourcesStr.length() < length) {
                StringBuilder stringBuilder = new StringBuilder(sourcesStr);
                while (stringBuilder.length() < length) {
                    stringBuilder.append(addStr);
                }
                return stringBuilder.toString();
            } else {
                return sourcesStr;
            }
        }
        return StringUtils.EMPTY;
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
