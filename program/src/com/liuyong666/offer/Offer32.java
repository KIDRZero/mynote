package com.liuyong666.offer;

public class Offer32 {
	
	/*
	 * ��1��n������1���ֵĴ���
	 * ��Ŀ����
	 * 		����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
	 * 		��������12����1��12��Щ�����а���1��������1,10,11��12,1һ��������5�Ρ�
	 * ˼·��
	 * 		���ó�������������
	 * 		ʱ�临�Ӷ�O(n*logn)
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
