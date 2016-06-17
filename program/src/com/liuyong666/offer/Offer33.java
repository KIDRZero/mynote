package com.liuyong666.offer;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Comparator;

public class Offer33 {
	/*
	 * �������ų���С����
	 * 
	 * ��Ŀ����
	 *		����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
	 *		������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
	 * ˼·��
	 * 		������ת��Ϊһ���ַ�������
	 * 		�����е�Ԫ����ӵ��ַ��������У�����Arrays.sort()������Ԫ�ؽ�������
	 * 		�����������������
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
