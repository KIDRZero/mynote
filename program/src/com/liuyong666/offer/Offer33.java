package com.liuyong666.offer;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Comparator;

public class Offer33 {
	/*
	 * 把数组排成最小的数
	 * 
	 * 题目描述
	 *		输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	 *		例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 * 思路：
	 * 		把数组转化为一个字符串数组
	 * 		把所有的元素添加到字符串数组中，利用Arrays.sort()把所有元素进行排序
	 * 		最后输出结果就是所求
	 */

	public String printMinNumberOfArray(int [] numbers) {
		if(numbers == null || numbers.length == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int len = numbers.length;
		String[] strs = new String[len];
		for(int i = 0; i < len; i++){
			strs[i] = numbers[i] + "";
		}
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		for(int i = 0; i < len; i++){
			sb.append(strs[i]);
		}
		return sb.toString();
    }
}
