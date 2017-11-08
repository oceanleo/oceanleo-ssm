package com.oceanleo.project.ssm.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/**
 * @author haiyang.li on 2017/10/11.
 */
public class BaseTest {

    public static void main(String[] args) {

        String message = "李海洋测试加密";
        try {
            String encrypt = encryptBASE(message.getBytes(Charset.forName("UTF-8")));
            System.out.println(encrypt);
            byte[] bytes = decryptBASE("5p2O5rW35rSL5rWL6K+V5Yqg5a+G");
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * BASE解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
