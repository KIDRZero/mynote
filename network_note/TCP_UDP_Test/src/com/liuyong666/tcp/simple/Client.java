package com.liuyong666.tcp.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
�ͻ��ˣ�
	ͨ������socket���󣬷����ڸö�����ʱ���Ϳ���ȥ����ָ��������
	��Ϊtcp���������ӵġ������ڽ���socket����ʱ��
	��Ҫ�з���˴��ڣ������ӳɹ����γ�ͨ·���ڸ�ͨ���������ݵĴ��䡣
����
	������˷��͸�һ���ı����ݡ�

���裺
	1.����Socket���񡣲�ָ��Ҫ���ӵ������Ͷ˿ڡ�
	2.Ϊ�˷������ݣ�Ӧ�û�ȡsocket���е��������
	3.����д����
	4.�ر�socket����

*/

public class Client {
	
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 10005);
		OutputStream os = socket.getOutputStream();
		os.write("hello�����ǿͻ��ˣ�".getBytes());
		socket.close();
	}

}
