package com.liuyong666.offer;

public class Offer43 {
	/*
	 * n个骰子的点数
	 * 题目描述：
	 * 		把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。
	 * 		输入n，打印出S的所有可能的值出现的概率。
	 * 分析: 
	 * 		一般来说骰子只有６面，点数为1~6，故n个骰子的最小和为n，最大和为6*n，
	 * 		则n个骰子的点数之和出现的频数可以用一个数组来保存，大小为6*n-n。
	 */
	public double[] getRatios(int n){
		if(n <= 0){
			return null;
		}
		double[] ratios = new double[6 * n - n + 1];
		double total = Math.pow(6, n);
		for(int i = 0; i < ratios.length; i++){
			ratios[i] = getFreq(i + n, n) / total;
		}
		return null;
	}

	private double getFreq(int sum, int n) {
		
		return 0;
	}

}
