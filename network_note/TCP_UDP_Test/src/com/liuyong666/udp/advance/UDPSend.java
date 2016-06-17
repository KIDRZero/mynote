package com.liuyong666.udp.advance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSend {
	
	public static String serverIP = "localhost";
	
	public static void main(String[] args) throws Exception {
		
		DatagramSocket datagramSocket = new DatagramSocket(6666);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		while((line = reader.readLine()) != null){
			byte[] buf = line.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length,
					InetAddress.getByName(serverIP), 10001);
			datagramSocket.send(datagramPacket);
			if("quit".equals(line)){
				break;
			}
		}
		
		datagramSocket.close();
		
	}
	

}
