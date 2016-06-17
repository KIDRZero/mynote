package com.liuyong666.offer;

public class Offer31 {
	/*
	 * 连续子数组的最大和
	 * 
	 * 题目描述：
	 * 		输入一个整型数组，数组里有正数也有负数。
	 * 		数组中一个或连续的多个整数组成一个子数组。
	 * 		求所有子数组的和的最大值。
	 * 		要求时间复杂度为O(n)
	 * 
	 * 思路：
	 * 		数组元素有正有负，子数组的和的最大值一定是正
	 * 		遍历的过程中逐步累加，当和为负进行更新，和为正继续累加。
	 * 		需要维护两个变量，一个表示与当前值相关的连续整数的和，一个表示遍历过程中曾经出现过的最大的连续整数和
	 */
	public int findGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0){
            return 0;
        }
		int len = array.length;
		int curSum = 0;
		int maxSum = 0x80000000;
		for(int i = 0; i < len; i++){
			if(curSum <= 0){
				curSum = array[i];
			}else{
				curSum += array[i];
			}
			if(curSum > maxSum){
				maxSum = curSum;
			}
		}
		return maxSum;
    }

	public static void main(String[] args) {
		new Offer31().findGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2});
	}
}
