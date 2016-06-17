package com.liuyong666.offer;

public class Offer42_2 {
	/*
	 * 左旋转字符串
	 * 
	 * 题目描述：
	 * 		字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
	 * 		请定义一个函数实现字符串左旋转操作的功能。
	 * 		比如输入字符串“abcdefg”和数字2，该函数返回左旋转2位得到的结果“cdefgab”。
	 */
	//使用Java切割拼串简介的代码
	public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0){
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        return str2 + str1;
    }
	

	//原地操作字符串的方法
	public String LeftRotateString1(String str,int n) {
        if(str == null || str.length() == 0 || n < 0){
            return "";
        }
        char[] chs = str.toCharArray();
        int len = chs.length;
        swap(chs, 0, n - 1);
        swap(chs, n, len - 1);
        swap(chs, 0, len - 1);
        return new String(chs);
    }
	
	private void swap(char[] a, int start, int end){
        while(start < end){
            char tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

}
