package com.liuyong666.offer;

public class Offer09_2 {
	/**
	 * 跳台阶
	 * 题目描述：
	 * 		一只青蛙一次可以跳上1级台阶，也可以跳上2级。
	 * 		求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 思路：
	 * 		只有一阶，一种跳法
	 * 		有两阶，两种跳法
	 * 		n阶跳法为f(n)，当n>2，第一次跳有两种选择：
	 * 			一是第一次只跳一级，此时跳法数目为f(n - 1)
	 * 			二是第一次跳两级，此时跳法数目为f(n -2)
	 * 		则f(n) = f(n - 1) + f(n - 2)
	 */
    public int jumpFloor(int target) {
		if(target <= 2){
            return target;
        }
        int left = 1;
        int right = 2;
        int sum = 0;
        for(int i = 3; i <= target; i++){
            sum = left + right;
            left = right;
            right = sum;
        }
        return sum;
    }
}
