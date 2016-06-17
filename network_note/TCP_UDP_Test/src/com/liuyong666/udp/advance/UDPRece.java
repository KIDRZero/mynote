package com.liuyong666.udp.advance;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPRece {
	
	public static void main(String[] args) throws Exception {
		
		DatagramSocket datagramSocket = new DatagramSocket(10001);
		
		while (true) {
			byte[] buf = new byte[1024];
			
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
			
			datagramSocket.receive(datagramPacket);
			
			String ip = datagramPacket.getAddress().getHostAddress();
			String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

			System.out.println(ip + "::" + data);
			if("quit".equals(data))
			{
				System.out.println(ip+"....Àë¿ªÁÄÌìÊÒ");
			}
			
			
		}
	}

}
