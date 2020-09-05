package com.oman.lib.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * UDP客户端：
 * 	发送"hello server  !!!"到服务端,服务端返回信息收到信息
 * 	步骤：
 * 	 1：创建DatagramPacket对象，包含数据以及InetAddress和端口号；
 * 	 2：创建DatagramSocket对象
 * 	 3：调用DatagramSocket对象的send方法发送数据
 * 	 4：可选的接收数据报包操作
 * 	 5:关闭相关的Socket对象
 * @author my
 */
public class UDPClient {
	public static void main(String[] args) {
		byte[] bs = "hello server  !!!".getBytes();
		DatagramSocket ds = null;
		try {
			// 1.创建DatagramPacket对象，包含数据以及InetAddress和端口号；
			DatagramPacket dp = new DatagramPacket(bs, 0, bs.length, InetAddress.getByName("LocalHost"), 10086);
			// 2：创建DatagramSocket对象
			ds = new DatagramSocket();
			// 3：调用DatagramSocket对象的send方法发送数据
			ds.send(dp);

			//接收来自服务端反馈的消息
			byte[] replay = new byte[1024];
			DatagramPacket rdp  = new DatagramPacket(replay, replay.length);
			ds.receive(rdp);
			System.out.println(new String(rdp.getData(),0,rdp.getLength()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭相关的Socket对象
			if (ds != null) {
				ds.close();
			}
		}
	}
}
