package com.liuyong666.offer;

public class Offer09_4 {
	/**
	 * ���θ���
	 * ��Ŀ������
	 * 		���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
	 * 		������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
	 * ˼·��
	 * 		n = 1,1��
	 * 		n = 2,���ţ���������
	 * 		n = 3����һ��С����������ѡ�񣬺��Ż�����
	 * 				�����ţ�������Ϊf(2)
	 * 				�����ţ����±�Ҳ������һ��Ҳ���ţ�������Ϊf(1)
	 * 
	 * 		f(n) = f(n - 1) + f(n - 2)
	 */
	
    public int rectCover(int target) {
    	if(target <= 2){
    		return target;
    	}
    	int left = 1;
    	int right = 2;
    	int sum = 0;
    	for(int i =3; i <= target; i++){
    		sum = left + right;
    		left = right;
    		right = sum;
    	}
    	return sum;
    }

}
