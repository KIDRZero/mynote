package com.liuyong666.offer;

public class Offer09_1 {
	/*
	 * 쳲���������
	 * ��Ŀ������
	 * 		Ҫ������һ������n���������쳲��������еĵ�n�
	 */
	
    public int fibonacci(int n) {
		if(n <= 1){
            return n;
        }
        int left = 0;
        int right = 1;
        int sum = 0;
        for(int i = 2; i <= n; i++){
            sum = left + right;
            left = right;
            right = sum;
        }
        return sum;
    }

}
