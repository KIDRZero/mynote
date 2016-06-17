package com.liuyong666.tcp.simple;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
����
	����˵�������ݲ���ӡ�ڿ���̨�ϡ�
�����:
	1����������˵�socket����ServerSocket();
		������һ���˿ڡ�
	2����ȡ���ӹ����Ŀͻ��˶���
		ͨ��ServerSokcet�� accept������û�����Ӿͻ�ȣ����������������ʽ�ġ�
	3���ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ���ÿͻ��˶���Ķ�ȡ������ȡ�����������ݡ�
		����ӡ�ڿ���̨��
	
	4���رշ���ˡ�����ѡ��
*/

public class Server {
	
	public static void main(String[] args) throws Exception {
		//���������socket���񡣲�����һ���˿�
		ServerSocket serverSocket = new ServerSocket(10005);
		
		//ͨ��accept������ȡ���ӹ����Ŀͻ��˶���
		while(true){
			Socket socket = serverSocket.accept();
			
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println(ip + " is connected!");
			
			//��ȡ�ͻ��˷��͹��������ݣ���ôҪʹ�ÿͻ��˶���Ķ�ȡ������ȡ����
			InputStream is = socket.getInputStream();
			
			byte[] buf = new byte[1024];
			int len = is.read(buf);
			
			System.out.println(new String(buf, 0, len));
			
			//�رտͻ���
			socket.close();
			
		}
		
	}
	
}
