package com.liuyong666.offer;

public class Offer09_1 {
	/*
	 * 斐波那契数列
	 * 题目描述：
	 * 		要求输入一个整数n，请你输出斐波那契数列的第n项。
	 */
	
    public int fibonacci(int n) {
		if(n <= 1){
            return n;
        }
        int left = 0;
        int right = 1;
        int sum = 0;
        for(int i = 2; i <= n; i++){
            sum = left + right;
            left = right;
            right = sum;
        }
        return sum;
    }

}
