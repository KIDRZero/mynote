package com.liuyong666.util;

public class GrayCode {
	public static void main(String[] args) {
		String[] str = getGray(4);
		for(String string:str){
			System.out.println(string);
		}
	}
	/*
	 * 格雷码(Gray Code)是一个数列集合，每个数使用二进位来表示，
	 * 假设使用n位元来表示每个数字，任两个数之间只有一个位元值不同。
	 * 如果要产生n位元的格雷码，那么格雷码的个数为2^n.
	 * n位元格雷码是基于n-1位元格雷码产生的。
	 */
	public static String[] getGray(int n) {
		
		String[] graycode = new String[(int) Math.pow(2, n)];
		
		if(n == 1){
			graycode[0] = "0";
			graycode[1] = "1";
			return graycode;
		}
		
		String[] last = getGray(n - 1);
		
		for(int i = 0;i < last.length;i++){
			graycode[i] = "0" + last[i];
			graycode[graycode.length - i - 1] = "1" + last[i];
			
		}
	        
		return graycode;
	}

}
