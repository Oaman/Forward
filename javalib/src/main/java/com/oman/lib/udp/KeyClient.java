package com.oman.lib.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 多线程实现聊天
 */
public class KeyClient {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ds = new DatagramSocket();
            boolean flag = true;
            while (flag) {
                String temp = br.readLine();
                byte[] bs = temp.getBytes();
                DatagramPacket dp = new DatagramPacket(bs, 0, bs.length, InetAddress.getLocalHost(), 22223);
                ds.send(dp);
                if (temp.equals("886")) {
                    flag = false;
                }
                // 接收来自服务端的数据
                byte[] rep = new byte[1024];
                DatagramPacket drp = new DatagramPacket(rep, rep.length);
                ds.receive(drp);
                System.out.println("来自服务端的消息" + new String(drp.getData(), 0, drp.getLength()));
            }

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
