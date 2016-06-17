package com.liuyong666.udp.simple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
����
	����һ��Ӧ�ó������ڽ���udpЭ�鴫������ݲ�����ġ�
	
����udp�Ľ��նˡ�
˼·��
	1������udpsocket����ͨ�������һ���˿ڡ���ʵ���Ǹ������������Ӧ�ó��������ֱ�ʶ��
		��������ȷ��Щ���ݹ�����Ӧ�ó�����Դ���
	2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݡ�
	��Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
	3��ͨ��socket�����receive�������յ������ݴ����Ѷ���õ����ݰ��С�
	4��ͨ�����ݰ���������й��ܡ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
	5���ر���Դ��

*/


public class UDPRece {
	public static void main(String[] args) throws Exception {
		//����udpsocket�������˿�
		DatagramSocket datagramSocket = new DatagramSocket(10000);
		
		//�������ݰ������ڴ洢����
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		
		//ʹ�÷���������ݲ��������ݰ�
		datagramSocket.receive(datagramPacket);//����ʽ����
		
		//ͨ�����ݰ��ķ�����ȡ����
		String ip = datagramPacket.getAddress().getHostAddress();
		String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
		int port = datagramPacket.getPort();
		System.out.println(ip + "::" + data + "::" + port);
		
		//�ر���Դ
		datagramSocket.close();
	}

}
