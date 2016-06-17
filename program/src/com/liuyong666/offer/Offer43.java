package com.liuyong666.offer;

public class Offer43 {
	/*
	 * n�����ӵĵ���
	 * ��Ŀ������
	 * 		��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��ΪS��
	 * 		����n����ӡ��S�����п��ܵ�ֵ���ֵĸ��ʡ�
	 * ����: 
	 * 		һ����˵����ֻ�У��棬����Ϊ1~6����n�����ӵ���С��Ϊn������Ϊ6*n��
	 * 		��n�����ӵĵ���֮�ͳ��ֵ�Ƶ��������һ�����������棬��СΪ6*n-n��
	 */
	public double[] getRatios(int n){
		if(n <= 0){
			return null;
		}
		double[] ratios = new double[6 * n - n + 1];
		double total = Math.pow(6, n);
		for(int i = 0; i < ratios.length; i++){
			ratios[i] = getFreq(i + n, n) / total;
		}
		return null;
	}

	private double getFreq(int sum, int n) {
		
		return 0;
	}

}
