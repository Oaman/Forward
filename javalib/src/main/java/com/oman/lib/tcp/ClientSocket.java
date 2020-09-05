package com.oman.lib.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端socket对象步骤： 1:创建Socket对象，必须指定host和port 2:I/O数据传输 3:关闭socket和IO流
 * <p>
 * 实现自己和自己聊天的功能
 *
 * @author my
 */
public class ClientSocket {
    public static void main(String[] args) {
        // 创建客户端Socket对象
        Socket s = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        BufferedReader sbr = null;
        try {
            s = new Socket(InetAddress.getLocalHost(), 3333);// 创建一个套接字并将其连接到指定主机上的指定端口号。
            // 把通道内的流给包装一下
            br = new BufferedReader(new InputStreamReader(System.in));// 创建一个转换流，通过键盘录入获取数据
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));// 创建一个转换输出流，读入键盘录入的数据给了s传入服务端
            sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));// 根据服务端获取的数据输出

            String temp = null;
            System.out.println("client before execute input");
            while ((temp = br.readLine()) != null) {
                // 键盘要自定义结束标记
                if ("886".equals(temp)) {
                    System.exit(0);
                }
                bw.write(temp);// 读入键盘录入的数据
                bw.newLine();// 换行
                bw.flush();// 刷新流里面的内容

                System.out.println("来自服务端的信息" + sbr.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
