package com.liuyong666.tcp.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class FileServer {
	
	private ServerSocket server;
	private Socket socket;
	
	
	public void getData(String savePath, int port){
		try{
			server = new ServerSocket(port);
			int progress = 0;
			while((socket = server.accept()) != null){
				DataInputStream socketIn = new DataInputStream(
						new BufferedInputStream(socket.getInputStream()));
				int bufferSize = 8192;
				byte[] buf = new byte[bufferSize];
				int passedLen = 0;
				long len = 0;
				
				if(!savePath.contains(".")){
					savePath += socketIn.readUTF();
				}
				
				DataOutputStream fileOut = new DataOutputStream(
						new BufferedOutputStream(new BufferedOutputStream(new FileOutputStream(savePath))));
				
				len = socketIn.readLong();
				System.out.println("文件的长度为：" + len + "KB");
				System.out.println("开始接收文件！");
				System.out.println("#>>>>>>>>>>>>>");
				System.out.println("#>>>>>>>>>>>>>>>>>");
				
				while(true){
					int read = 0;
					if(socketIn != null){
						read = socketIn.read(buf);
					}
					passedLen += read;
					if(read == -1){
						break;
					}
					if((int)(passedLen * 100.0 / len) - progress > 0){
						progress = (int)(passedLen * 100.0 / len);
						System.out.println("文件接收了" + progress + "%");
						System.out.println(">");
					}
					fileOut.write(buf, 0, read);
				}
				System.out.println("接收完成，文件存为：" + savePath);
				fileOut.close();
				socket.close();
			}
		}catch(Exception e){
			System.err.println("File Server Exception:" + e);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("usage: FileServer <save path> <port>");
			System.exit(-1);
		}
//		new FileServer().getData("F:\\", 12000);
		new FileServer().getData(args[0], Integer.parseInt(args[1]));
	}

}
