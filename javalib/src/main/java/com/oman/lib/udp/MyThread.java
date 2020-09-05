package com.oman.lib.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyThread implements Runnable {

	private DatagramPacket dp;


	public MyThread(DatagramPacket dp) {
		super();
		this.dp = dp;
	}


	@Override
	public void run() {
		while(true){
			String str = new String(dp.getData(), 0, dp.getLength());
			System.out.println("来自客户端的消息" + dp.getSocketAddress() + ":" + str);
		}
	}
}
