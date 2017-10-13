package com.ocean.project.ssm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author haiyang.li on 2017/10/11.
 */
public class MdTest {

    public static String encryptMD(String dataSource) {
        try {
            System.out.println("加密前数据" + dataSource);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            byte[] bytes = dataSource.getBytes("UTF-8");
            messageDigest.update(bytes);
            BigInteger bigInteger = new BigInteger(messageDigest.digest());
            System.out.println("加密后数据"+bigInteger.toString());
            return bigInteger.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        encryptMD("12345");
    }
}
