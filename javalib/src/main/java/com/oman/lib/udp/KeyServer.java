package com.oman.lib.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class KeyServer {
    public static void main(String[] args) {
        try {
            while (true) {
                byte[] bs = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bs, bs.length);
                DatagramSocket ds = new DatagramSocket(22223);
                ds.receive(dp);
                new Thread(new MyThread(dp)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
