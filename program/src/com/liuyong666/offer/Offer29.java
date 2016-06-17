package com.liuyong666.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer29 {
	/*
	 * 数组中出现次数超过一半的数字
	 * 
	 * 题目描述
	 * 		数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 		例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
	 * 		由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
	 */
	public static void main(String[] args) {
		int a = new Offer29().moreThanHalfNum(new int[]{1,2,3,2,2,2,5,4,2});
		System.out.println(a);
	}
    public int moreThanHalfNum(int [] array) {
     
    	if(array == null || array.length == 0){
    		return 0;
    	}
    	int flag = 0;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int len = array.length;
    	for(int i = 0; i < len; i++){
    		if(map.containsKey(array[i])){
    			map.put(array[i], map.get(array[i]) + 1);
    		}else{
    			map.put(array[i], 1);
    		}
    		if(map.get(array[i]) > len / 2){
    			flag = array[i];
    			break;
    		}
    	}
    	return flag;
    }
    /*
     * 思路2：
     * 		由于有一个数字出现的次数超过数组长度的一半，那么该数字出现的次数一定大于其他数字出现次数之和
     * 		设置标识变量，遇到相同的数字，就把次数加1，如果没有遇到就把次数减1
     * 		出现次数超过一半的数字肯定是最后一次把times变量设为1对应的数字
     * 		举一个极端的例子，该数字在其他数字之后连续出现，此时times变量应该是一个负值了，
     * 		那么当该数字的出现次数与前面所有数字的出现次数相等的时候，times变量变为0，
     * 		由于其次数超过一半，那么该变量别重新赋值为1，所以就找到了该数字。
     * 
     * 		由于有一个数字的次数超过一半，所以那个数字
     * 		肯定是最后一次吧times变量设为1对应的数字
     * 
     * 		一次删掉两个不同的数
     */
    public int moreThanHalfNum1(int[] array) {
    	if(array == null || array.length == 0){
    		return 0;
    	}
    	int times = 1;
    	int result = array[0];
    	for(int i = 1; i < array.length; i++){
    		if(times == 0){
    			result = array[i];
    			times = 1;
    		}else if(array[i] == result){
    			//遇到相同的数字次数就增加1
    			times++;
    		}else{
    			//没有遇到相同的就把次数减1
    			times--;
    		}
    	}
    	if(!checkMoreThanHalfNum(array, result)){
    		return 0;
    	}
    	return result;
    }
    //检查该数字是否出现的次数超过一半
    private boolean checkMoreThanHalfNum(int[] array, int result){
    	int times = 0;
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == result){
    			times++;
    		}
    	}
    	boolean isMoreThanHalf = true;
    	if(times * 2 <= array.length){
    		isMoreThanHalf = false;
    	}
    	return isMoreThanHalf;
    }

}
