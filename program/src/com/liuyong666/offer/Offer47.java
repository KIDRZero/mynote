package com.liuyong666.offer;

public class Offer47 {
	/*
	 * 不用加减乘除做加法
	 * 题目描述
	 * 		写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	 */

	public int Add(int num1,int num2) {
		//sum通过异或得到无进位和，carry为产生的进位，并左移一位
		int sum, carry;
		do{
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}while(num2 != 0);
		
		return num1;
    }
}
