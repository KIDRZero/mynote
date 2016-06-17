package com.liuyong666.udp.simple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/*
需求：通过udp传输方式，将一段文字数据发送出去。，
定义一个udp发送端。
思路：
1，建立updsocket服务。
2，提供数据，并将数据封装到数据包中。
3，通过socket服务的发送功能，将数据包发出去。
4，关闭资源。
*/
public class UDPSend {
	public static String serverIP = "localhost";
	public static void main(String[] args) throws Exception {
		
		//使用DatagramSocket对象创建UDP服务
		DatagramSocket datagramSocket  = new DatagramSocket(6666);
		
		//确定数据，并封装成数据包
		byte[] buf = "我是来自UDP协议的发送方！".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length,
				InetAddress.getByName(serverIP), 10000);
		//通过socket服务，将已有的数据包发送出去。
		datagramSocket.send(datagramPacket);
		
		//关闭资源
		datagramSocket.close();
	}

}
