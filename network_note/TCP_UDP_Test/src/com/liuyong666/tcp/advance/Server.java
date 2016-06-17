package com.liuyong666.tcp.advance;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		//建立服务端socket服务。并监听一个端口
		ServerSocket serverSocket = new ServerSocket(10005);
		
		//通过accept方法获取连接过来的客户端对象
		while(true){
			Socket socket = serverSocket.accept();
			
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println(ip + " is connected!");
			
			//获取客户端发送过来的数据，那么要使用客户端对象的读取流来读取数据
			InputStream is = socket.getInputStream();
			
			byte[] buf = new byte[1024];
			int len = is.read(buf);
			
			System.out.println(new String(buf, 0, len));
			
			
			OutputStream os = socket.getOutputStream();
			Thread.sleep(10000);
			os.write(("我知道你连上我了！你的IP是：" + ip).getBytes());
			
			//关闭客户端
			socket.close();
			
		}
		
	}
}
