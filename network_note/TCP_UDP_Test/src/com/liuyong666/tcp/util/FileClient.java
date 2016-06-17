package com.liuyong666.tcp.util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class FileClient {
	
	private Socket socket;
	
	public void sendData(String filePath, String ip, int port){
		int progress = 0;
		DataOutputStream socketOut = null;
		DataInputStream fileIn = null;
		
		try{
			File file = new File(filePath);
			fileIn = new DataInputStream(
					new BufferedInputStream(new FileInputStream(filePath)));
			socket = new Socket(ip, port);
			socketOut = new DataOutputStream(socket.getOutputStream());

			socketOut.writeUTF(file.getName());
			socketOut.flush();
			socketOut.writeLong(file.length());
			socketOut.flush();
			int bufferSize = 8192;
			byte[] buf = new byte[bufferSize];
			
			while(true){
				int read = 0;
				if(fileIn != null){
					read = fileIn.read(buf);
				}
				progress += Math.abs(read);
				
				if(read == -1){
					break;
				}
				
				socketOut.write(buf, 0, read);
				
				System.out.println("文件已发送：" + (int)(100.0 * progress / file.length()) + "%");
			}
			socketOut.flush();
			System.out.println("\n文件已上传完毕！");
		}catch(Exception e){
			System.err.println("File Client Exception:" + e);
			System.exit(-1);
		}finally{
			try{
				if(socketOut != null){
					socketOut.close();
				}
				
				if(fileIn != null){
					fileIn.close();
				}
				if(socket != null){
					socket.close();
				}
			}catch(Exception e){
			}
		}
		
	}
	
	public static void main(String[] args) {
		if(args.length != 3){
			System.err.println("usage:FileClient:<file path> <server address> <port number>");
			System.exit(-1);
		}
//		new FileClient().sendData("D:\\PC安装包\\jdk\\jdk-1_5_0_22-windows-i586-p.exe", "localhost", 12000);
		try {
			new FileClient().sendData(args[0], args[1], Integer.parseInt(args[2]));
		} catch (Exception e) {
			System.err.println("输入有误，请确认参数是否正确！！！");
			System.exit(-1);
		}
	}

}
