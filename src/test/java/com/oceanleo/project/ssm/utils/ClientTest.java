package com.oceanleo.project.ssm.utils;

import com.oceanleo.project.ssm.support.utils.DateUtils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author haiyang.li on 2017/9/26.
 */
public class ClientTest {

    public void send(String text) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 10086);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            byte[] b = text.getBytes("UTF-8");
            bufferedOutputStream.write(b);
            System.out.println(DateUtils.formatCurrentTime() + " 发送消息成功,发送内容:" + text);
            bufferedOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
