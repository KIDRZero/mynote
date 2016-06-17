package com.liuyong666.offer;

public class Offer52 {
	/*
	 * 构建乘积数组
	 * 题目描述
	 * 		给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
	 * 		其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
	 * 		不能使用除法。
	 */
	//思路：把前半部分与后半部分的结果保存到不同的数组中
	public int[] multiply(int[] A) {

		if(A == null || A.length <= 1){
			return null;
		}
		int n = A.length;
		//front[i]就是从A[0]...到A[i - 1]的值
		int[] front = new int[n];
		//back[i]就是从A[i + 1]...到A[n - 1]的值
		//back数组的第一位从最后一位开始，所以back[n - 1] = 1
		int[] back = new int[n];
		front[0] = back[n - 1] = 1;
		//分别计算前半部分和后半部分的值，并分别将结果保存在front与back数组中
		for(int i = 1; i < n; i++){
			front[i] = front[i - 1] * A[i - 1];
			back[n - 1 - i] = back[n - i] * A[n - i];
		}
		//将两个计算结果再次相乘得到最后的结果
		for(int i = 0; i < n; i++){
			front[i] *= back[i];
		}
		//返回front数组
		return front;
    }

}
