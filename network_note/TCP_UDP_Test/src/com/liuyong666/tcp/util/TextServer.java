package com.liuyong666.tcp.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TextServer {
	
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(10006);
		
		Socket socket = serverSocket.accept();
		
		String ip = socket.getInetAddress().getHostAddress();
		System.out.println(ip + " is connected!");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter out = new PrintWriter(new FileWriter("server.txt"), true);
		
		String line = null;
		while((line = reader.readLine()) != null){
			System.out.println("from client:" + line);
			out.println(line);
		}
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		pw.println("上传成功");;
		
		out.close();
		socket.close();
		serverSocket.close();
	}

}
