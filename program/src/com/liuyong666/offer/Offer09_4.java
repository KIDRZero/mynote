package com.liuyong666.offer;

public class Offer09_4 {
	/**
	 * 矩形覆盖
	 * 题目描述：
	 * 		我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
	 * 		请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * 思路：
	 * 		n = 1,1种
	 * 		n = 2,横着，竖着两种
	 * 		n = 3，第一个小矩形有两种选择，横着或竖着
	 * 				若竖着，方法数为f(2)
	 * 				若横着，它下边也必须有一个也横着，方法数为f(1)
	 * 
	 * 		f(n) = f(n - 1) + f(n - 2)
	 */
	
    public int rectCover(int target) {
    	if(target <= 2){
    		return target;
    	}
    	int left = 1;
    	int right = 2;
    	int sum = 0;
    	for(int i =3; i <= target; i++){
    		sum = left + right;
    		left = right;
    		right = sum;
    	}
    	return sum;
    }

}
