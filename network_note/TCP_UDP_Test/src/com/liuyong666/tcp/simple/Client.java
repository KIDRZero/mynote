package com.liuyong666.tcp.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
客户端，
	通过查阅socket对象，发现在该对象建立时，就可以去连接指定主机。
	因为tcp是面向连接的。所以在建立socket服务时，
	就要有服务端存在，并连接成功。形成通路后，在该通道进行数据的传输。
需求：
	给服务端发送给一个文本数据。

步骤：
	1.创建Socket服务。并指定要连接的主机和端口。
	2.为了发送数据，应该获取socket流中的输出流。
	3.数据写入流
	4.关闭socket服务

*/

public class Client {
	
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 10005);
		OutputStream os = socket.getOutputStream();
		os.write("hello，我是客户端！".getBytes());
		socket.close();
	}

}
