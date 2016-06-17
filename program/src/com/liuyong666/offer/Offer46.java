package com.liuyong666.offer;

public class Offer46 {
	/*
	 * 求1+2+3+...+n
	 * 题目描述:
	 * 		求1+2+3+...+n，
	 * 		要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 */
	class SumOfN{
		
		private int result = 0;
		
		public int Sum_Solution(int n) {
			compute(n);
			return result;
	    }

		private boolean compute(int n) {
			result += n;
			return n != 0 && compute(n - 1);
		}
	}

}
