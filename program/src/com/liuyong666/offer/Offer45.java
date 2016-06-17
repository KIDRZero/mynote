package com.liuyong666.offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Offer45 {
	/*
	 * ԲȦ�����ʣ�µ�����
	 * ��Ŀ������
	 * 		0, 1, �� , n-1 �� n �������ų�һ��ȦȦ�������� 0 ��ʼÿ�δ�Բ����ɾ���� m �����֡�
	 * 		������ȦȦ��ʣ�µ����һ�����֡�
	 */
	public int lastRemaining(int n, int m) {
		if(n < 1 || m < 1){
			return -1;
		}
		int[] a = new int[n];
		//��ǰ�����Ķ���
		int cur = -1;
		//Ȧ�еĸ���
		int num = n;
		//�Ʋ���
		int count = 0;
		while(num > 0){
			//�ƶ����ϴα�ɾ��Ԫ�ص���һ��Ԫ��
			cur++;
			//���������һ������ʱ�򣬴ӿ�ͷ���¼���
			if(cur == n){
				cur = 0;
			}
			//����������ϴα�ɾ���Ķ����������ö���
			if(a[cur] == -1){
				continue;
			}
			//�Ʋ�����1
			count++;
			if(count == m){
				//�ѵ�ǰԪ�ر��Ϊ��ɾ��
				a[cur] = -1;
				//�Ʋ������¸�λ
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
