package com.liuyong666.offer;

public class Offer34 {
	/*
	 * Ѱ�ҳ���
	 * ��Ŀ������
	 * 		��ֻ��������2��3��5��������������Ugly Number����
	 * 		����6��8���ǳ�������14���ǣ���Ϊ����������7�� ϰ�������ǰ�1�����ǵ�һ��������
	 * 		�󰴴�С�����˳��ĵ�N��������
	 */
	 public int getUglyNumber(int index){
		 if(index <= 0){
	            return 0;
	     }
	     int[] uglyNumbers = new int[index];
	     uglyNumbers[0] = 1;
	     int nextUglyNumberIndex = 1;
	     int mulNum2 = 0;
	     int mulNum3 = 0;
	     int mulNum5 = 0;
	     while(nextUglyNumberIndex < index){
	    	 int min = min(uglyNumbers[mulNum2] * 2,
	    			 uglyNumbers[mulNum3] * 3,
	    			 uglyNumbers[mulNum5] * 5);
	    	 uglyNumbers[nextUglyNumberIndex] = min;
	    	 nextUglyNumberIndex++;
	    	 while(uglyNumbers[mulNum2] * 2 == min){
	    		 mulNum2++;
	    		 }
	    	 while(uglyNumbers[mulNum3] * 3 == min){
	    		 mulNum3++;
	    	 }
	    	 while(uglyNumbers[mulNum5] * 5 == min){
	    		 mulNum5++;
	         }
	     }
	     return uglyNumbers[nextUglyNumberIndex - 1];
	        
	 }
	 private int min(int i, int j, int k){
		 int min = i < j ? i : j;
		 return min < k ? min : k;
	 }
}
	
