package com.oman.lib.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 1 创建ServerSocket指定端口号
 * 2 调用accept方法等待获取客户端的socket对象  会阻塞在这里
 * 3 等有消息的时候就会执行while体中的方法
 */
public class TestServerSocket {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        BufferedReader br2 = null;
        try {
            // 创建服务器Socket对象
            ss = new ServerSocket(3333);// 连接客户端接口
            System.out.println("服务端已经启动!!!");
            // 监听客户端连接
            System.out.println("server execute before accept");//TODO 服务端启动时候会阻塞在这里
            s = ss.accept();// s里面通过方法获得了客户端数据
            System.out.println("server execute after accept");//服务端启动时候会阻塞在这里
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));//通过端口得到了客户端传入的数据
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//bw2直接读取键盘录入数据和当前主机的名字
            br2 = new BufferedReader(new InputStreamReader(System.in));// 通过键盘获取数据
            System.out.println("server prepare get content");
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println("来自客户端的消息：" + temp);// 输出客户端数据
                bw.write(s.getInetAddress() + ":" + br2.readLine());//bw2直接读取键盘录入数据和当前主机的名字
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }
    }
}
