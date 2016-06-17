package com.liuyong666.udp.simple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
需求：
	定义一个应用程序，用于接收udp协议传输的数据并处理的。
	
定义udp的接收端。
思路：
	1，定义udpsocket服务。通常会监听一个端口。其实就是给这个接收网络应用程序定义数字标识。
		方便于明确哪些数据过来该应用程序可以处理。
	2，定义一个数据包，因为要存储接收到的字节数据。
	因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。
	3，通过socket服务的receive方法将收到的数据存入已定义好的数据包中。
	4，通过数据包对象的特有功能。将这些不同的数据取出。打印在控制台上。
	5，关闭资源。

*/


public class UDPRece {
	public static void main(String[] args) throws Exception {
		//创建udpsocket，建立端口
		DatagramSocket datagramSocket = new DatagramSocket(10000);
		
		//定义数据包，用于存储数据
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		
		//使用服务接收数据并存入数据包
		datagramSocket.receive(datagramPacket);//阻塞式方法
		
		//通过数据包的方法获取数据
		String ip = datagramPacket.getAddress().getHostAddress();
		String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
		int port = datagramPacket.getPort();
		System.out.println(ip + "::" + data + "::" + port);
		
		//关闭资源
		datagramSocket.close();
	}

}
