package com.liuyong666.offer;

public class Offer40 {
	/*
	 * 数组中只出现一次的数字
	 * 题目描述
	 * 		一个整型数组里除了两个数字之外，其他的数字都出现了两次。
	 * 		请写程序找出这两个只出现一次的数字。T:O(n)  S:O(1)
	 */
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
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
