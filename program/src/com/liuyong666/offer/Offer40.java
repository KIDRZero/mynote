package com.liuyong666.offer;

public class Offer40 {
	/*
	 * ������ֻ����һ�ε�����
	 * ��Ŀ����
	 * 		һ�����������������������֮�⣬���������ֶ����������Ρ�
	 * 		��д�����ҳ�������ֻ����һ�ε����֡�T:O(n)  S:O(1)
	 */
	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array == null || array.length < 2){
            return;
        }
		int res = array[0];
        for(int i = 1; i < array.length; i++){
            res ^= array[i];
        }
        int save_res = res;
        int k = 0;
        while((res & 0x01) != 1){
            k++;
            res >>= 1;
        }
        int _res = 0;
        for(int i = 0; i < array.length; i++){
            if(((array[i] >> k) & 0x01) == 1){
                _res ^= array[i];
            }
        }
        num1[0] = _res;
        num2[0] = save_res ^ _res;
        
    }
	public static void main(String[] args) {
		int[] a = new int[1];
		int[] b = new int[1];
		FindNumsAppearOnce(new int[]{1},a,b);
		System.out.println(a[0]+":"+b[0]);
	}

}
