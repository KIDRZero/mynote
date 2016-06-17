package com.liuyong666.offer;

public class Offer31 {
	/*
	 * ���������������
	 * 
	 * ��Ŀ������
	 * 		����һ���������飬������������Ҳ�и�����
	 * 		������һ���������Ķ���������һ�������顣
	 * 		������������ĺ͵����ֵ��
	 * 		Ҫ��ʱ�临�Ӷ�ΪO(n)
	 * 
	 * ˼·��
	 * 		����Ԫ�������и���������ĺ͵����ֵһ������
	 * 		�����Ĺ��������ۼӣ�����Ϊ�����и��£���Ϊ�������ۼӡ�
	 * 		��Ҫά������������һ����ʾ�뵱ǰֵ��ص����������ĺͣ�һ����ʾ�����������������ֹ�����������������
	 */
	public int findGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0){
            return 0;
        }
		int len = array.length;
		int curSum = 0;
		int maxSum = 0x80000000;
		for(int i = 0; i < len; i++){
			if(curSum <= 0){
				curSum = array[i];
			}else{
				curSum += array[i];
			}
			if(curSum > maxSum){
				maxSum = curSum;
			}
		}
		return maxSum;
    }

	public static void main(String[] args) {
		new Offer31().findGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2});
	}
}
