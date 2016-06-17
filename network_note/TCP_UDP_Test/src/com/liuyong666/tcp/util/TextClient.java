package com.liuyong666.tcp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TextClient {
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 10006);
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;//输入是否正确的标记

		BufferedReader reader = null;
		while(flag){
			System.out.println("please input the filepath that you want to upload(eg:C:\\a.txt):");
			String filepath = sc.nextLine();
			
			//提取文件名
			String filename = filepath.substring(filepath.lastIndexOf('\\') + 1);
			try{
				reader = new BufferedReader(new FileReader(filepath));
				flag = false;
			}catch(Exception e){
				System.out.println("输入有误！请输入正确的文件格式！");
			}
		}
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		String line = null;
		while((line = reader.readLine()) != null){
			out.println(line);
		}
		
		//关闭客户端的输出流。相当于给流中加一个结束标记-1
		socket.shutdownOutput();
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String result = bufIn.readLine();
		System.out.println(result);
		
		
		reader.close();
		
		socket.close();
	}

}
