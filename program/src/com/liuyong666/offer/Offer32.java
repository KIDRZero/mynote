package com.liuyong666.offer;

public class Offer32 {
	
	/*
	 * 从1到n整数中1出现的次数
	 * 题目描述
	 * 		输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
	 * 		例如输入12，从1到12这些整数中包含1的数字有1,10,11和12,1一共出现了5次。
	 * 思路：
	 * 		利用除法和求余运算
	 * 		时间复杂度O(n*logn)
	 */

	public int numberOf1Between1AndN(int n) {
		if(n <= 0){
			return 0;
		}
	    int count = 0;
	    for(int i  = 1; i <= n; i++){
	    	count += numberOf1(i);
	    }
		return count;
    }

	private int numberOf1(int i) {
		int num = 0;
		while(i > 0){
			if(i % 10 == 1){
				num++;
			}
			i /= 10;
		}
		return num;
	}
}
