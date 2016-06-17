package com.liuyong666.offer;

public class Offer36 {
	/*
	 * 数组中的逆序对
	 * 题目描述：
	 * 		在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
	 * 		输入一个数组，求出这个数组中的逆序对的总数。
	 * 思路：
	 * 		分而治之的思想
	 * 		递归地分解成长度为1的子数组后
	 * 		合并排序，并统计逆序对
	 * 		利用归并排序的思路
	 */
    public int inversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }
        
        return mergerCount(array, copy, 0, array.length - 1);
        
    }
    private int mergerCount(int[] array, int[] copy, int start, int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int len = (end - start) / 2;
        int leftCount = mergerCount(copy, array, start, start + len);
        int rightCount = mergerCount(copy, array, start + len + 1, end);
        //i指向第一个数组的最后一个下标，j指向第二个数组的最后一个下标
        int i = start + len;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + len + 1){
            if(array[i] > array[j]){
                copy[indexCopy--] = array[i--];
                count += j - start - len;
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(; i >= start; i--){
			copy[indexCopy--] = array[i];
        }
        for(; j >= start + len + 1; j--){
            copy[indexCopy--] = array[j];
        }
        
        return count + leftCount + rightCount;
    }
    
    public static void main(String[] args) {
		int x = new Offer36().inversePairs(new int[]{1,2,3,4,7,6,5});
		System.out.println(x);
	}
	

}
