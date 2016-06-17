package com.liuyong666.util;

public class GrayCode {
	public static void main(String[] args) {
		String[] str = getGray(4);
		for(String string:str){
			System.out.println(string);
		}
	}
	/*
	 * ������(Gray Code)��һ�����м��ϣ�ÿ����ʹ�ö���λ����ʾ��
	 * ����ʹ��nλԪ����ʾÿ�����֣���������֮��ֻ��һ��λԪֵ��ͬ��
	 * ���Ҫ����nλԪ�ĸ����룬��ô������ĸ���Ϊ2^n.
	 * nλԪ�������ǻ���n-1λԪ����������ġ�
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
