package com.liuyong666.offer;

public class Offer34 {
	/*
	 * 寻找丑数
	 * 题目描述：
	 * 		把只包含因子2、3和5的数称作丑数（Ugly Number）。
	 * 		例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
	 * 		求按从小到大的顺序的第N个丑数。
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
	
