package com.oman.lib.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP服务端： 步骤： 1：创建空的DatagramPacket对象 2：创建DatagramSocket对象
 * 3:使用receive方法填充DatagramPacket对象 4:获取DatagramPacket内容 5：关闭DatagramSocket对象
 */
public class UDPServer {
    public static void main(String[] args) {
        byte[] bs = new byte[1024];
        DatagramSocket ds = null;
        // 1：创建空的DatagramPacket对象
        try {
            DatagramPacket dp = new DatagramPacket(bs, bs.length);
            // 2：创建DatagramaSocket对象
            ds = new DatagramSocket(10086);
            // 3:使用receive方法填充DatagramPacket对象
            System.out.println("server execute before receive");//TODO 服务端启动时候会阻塞在这里
            ds.receive(dp);
            System.out.println("server execute after receive");//TODO 服务端启动时候会阻塞在这里
            // 4:获取DatagramPacket内容
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("来自客户端的消息：" + str);
            // 给客户端发消息说收到信息
            byte[] replay = "已经收到 hello server!!!".getBytes();
            DatagramPacket rdp = new DatagramPacket(replay, 0, replay.length, dp.getAddress(), dp.getPort());
            ds.send(rdp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
