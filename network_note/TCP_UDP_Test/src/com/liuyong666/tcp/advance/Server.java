package com.liuyong666.tcp.advance;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
			
			
			OutputStream os = socket.getOutputStream();
			Thread.sleep(10000);
			os.write(("��֪�����������ˣ����IP�ǣ�" + ip).getBytes());
			
			//�رտͻ���
			socket.close();
			
		}
		
	}
}
