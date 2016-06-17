package com.liuyong666.udp.simple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/*
����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ����
����һ��udp���Ͷˡ�
˼·��
1������updsocket����
2���ṩ���ݣ��������ݷ�װ�����ݰ��С�
3��ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ��
4���ر���Դ��
*/
public class UDPSend {
	public static String serverIP = "localhost";
	public static void main(String[] args) throws Exception {
		
		//ʹ��DatagramSocket���󴴽�UDP����
		DatagramSocket datagramSocket  = new DatagramSocket(6666);
		
		//ȷ�����ݣ�����װ�����ݰ�
		byte[] buf = "��������UDPЭ��ķ��ͷ���".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length,
				InetAddress.getByName(serverIP), 10000);
		//ͨ��socket���񣬽����е����ݰ����ͳ�ȥ��
		datagramSocket.send(datagramPacket);
		
		//�ر���Դ
		datagramSocket.close();
	}

}
