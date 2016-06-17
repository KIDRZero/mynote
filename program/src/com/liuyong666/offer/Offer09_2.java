package com.liuyong666.offer;

public class Offer09_2 {
	/**
	 * ��̨��
	 * ��Ŀ������
	 * 		һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
	 * 		�����������һ��n����̨���ܹ��ж�����������
	 * ˼·��
	 * 		ֻ��һ�ף�һ������
	 * 		�����ף���������
	 * 		n������Ϊf(n)����n>2����һ����������ѡ��
	 * 			һ�ǵ�һ��ֻ��һ������ʱ������ĿΪf(n - 1)
	 * 			���ǵ�һ������������ʱ������ĿΪf(n -2)
	 * 		��f(n) = f(n - 1) + f(n - 2)
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
