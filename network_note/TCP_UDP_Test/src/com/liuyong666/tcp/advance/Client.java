package com.liuyong666.tcp.advance;
/*
��ʾtcp�Ĵ���Ŀͻ��˺ͷ���˵Ļ��á�

����
	�ͻ��˸�����˷������ݣ�������յ��󣬸��ͻ��˷�����Ϣ��
�ͻ��ˣ�
	1������socket����ָ��Ҫ���������Ͷ˿ڡ�
	2����ȡsocket���е��������������д�������С�ͨ�����緢�͸�����ˡ�
	3����ȡsocket���е���������������˷��������ݻ�ȡ��������ӡ��
	4���رտͻ�����Դ��
*/

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 10005);
		OutputStream os = socket.getOutputStream();
		os.write("hello�����ǿͻ��ˣ�".getBytes());
		
		InputStream is = socket.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf, 0, len));
		
		socket.close();
	}
}
