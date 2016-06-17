package com.liuyong666.offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Offer45 {
	/*
	 * 圆圈中最后剩下的数字
	 * 题目描述：
	 * 		0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。
	 * 		求出这个圈圈里剩下的最后一个数字。
	 */
	public int lastRemaining(int n, int m) {
		if(n < 1 || m < 1){
			return -1;
		}
		int[] a = new int[n];
		//当前遇到的对象
		int cur = -1;
		//圈中的个数
		int num = n;
		//计步器
		int count = 0;
		while(num > 0){
			//移动到上次被删除元素的下一个元素
			cur++;
			//当遇到最后一个数的时候，从开头重新计算
			if(cur == n){
				cur = 0;
			}
			//如果遇到了上次被删除的对象，则跳过该对象
			if(a[cur] == -1){
				continue;
			}
			//计步器加1
			count++;
			if(count == m){
				//把当前元素标记为已删除
				a[cur] = -1;
				//计步器重新复位
				count = 0;
				num--;
			}
		}
		return cur;
    }

	public int LastRemaining_Solution(int n, int m) {
		if(n < 1 || m < 1){
			return -1;
		}
		int lastNumber = 0;
        for(int i = 2; i <= n; i++){
			lastNumber = (lastNumber + m) % i;
        }
        return lastNumber;
	}
	public static void main(String[] args) {
		System.out.println(new Offer45().LastRemaining_Solution(5, 3));;
	}
}
