package com.liuyong666.offer;

public class Offer10 {
	/*
	 * 二进制中1的个数
	 * 题目描述：
	 * 		输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * 		比如输入9，9的二进制表示是1001，1的个数是2，所以输出2。
	 * 
	 * 思路：
	 * 		一个数与该数减一的结果进行与运算，会把该数右边（低位）第一个1变为0，而该位左边保持不变（高位）。
	 */
	
	public int  numberOf1(int n) {
        int count = 0; 
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;     
    }

}
