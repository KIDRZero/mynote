package com.liuyong666.offer;

public class Offer47 {
	/*
	 * ���üӼ��˳����ӷ�
	 * ��Ŀ����
	 * 		дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
	 */

	public int Add(int num1,int num2) {
		//sumͨ�����õ��޽�λ�ͣ�carryΪ�����Ľ�λ��������һλ
		int sum, carry;
		do{
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}while(num2 != 0);
		
		return num1;
    }
}
