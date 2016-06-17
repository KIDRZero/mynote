package com.liuyong666.offer;

public class Offer46 {
	/*
	 * ��1+2+3+...+n
	 * ��Ŀ����:
	 * 		��1+2+3+...+n��
	 * 		Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
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
