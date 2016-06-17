package com.liuyong666.offer;

public class Offer52 {
	/*
	 * �����˻�����
	 * ��Ŀ����
	 * 		����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
	 * 		����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
	 * 		����ʹ�ó�����
	 */
	//˼·����ǰ�벿�����벿�ֵĽ�����浽��ͬ��������
	public int[] multiply(int[] A) {

		if(A == null || A.length <= 1){
			return null;
		}
		int n = A.length;
		//front[i]���Ǵ�A[0]...��A[i - 1]��ֵ
		int[] front = new int[n];
		//back[i]���Ǵ�A[i + 1]...��A[n - 1]��ֵ
		//back����ĵ�һλ�����һλ��ʼ������back[n - 1] = 1
		int[] back = new int[n];
		front[0] = back[n - 1] = 1;
		//�ֱ����ǰ�벿�ֺͺ�벿�ֵ�ֵ�����ֱ𽫽��������front��back������
		for(int i = 1; i < n; i++){
			front[i] = front[i - 1] * A[i - 1];
			back[n - 1 - i] = back[n - i] * A[n - i];
		}
		//�������������ٴ���˵õ����Ľ��
		for(int i = 0; i < n; i++){
			front[i] *= back[i];
		}
		//����front����
		return front;
    }

}
