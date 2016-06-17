package com.liuyong666.offer;

import java.util.Arrays;

public class Offer24 {
	/*
	 * 题目描述：
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	 * 如果是则返回ture,否则返回false。假设输入的数组的任意两个数字都互不相同。
	 */
    public boolean verifySquenceOfBST(int [] sequence) {
        
    	if(sequence == null || sequence.length == 0){
    		return false;
    	}
    	
    	int len = sequence.length;
    	int root = sequence[len - 1];
    	
    	int i = 0;
    	for(; i < len - 1; i++){
    		if(sequence[i] > root){
    			break;
    		}
    	}
    	
    	int j = i;
    	for(;j < len - 1; j++){
    		if(sequence[j] < root){
    			return false;
    		}
    	}
    	
    	boolean left = true;
    	boolean right = true;
    	if(i > 0){
    		left = verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
    	}
    	if(i < len - 1){
    		right = verifySquenceOfBST(Arrays.copyOfRange(sequence,i,len - 1));
    	}
    	
    	return left && right;
    }
    
    public static void main(String[] args) {
		int[] seq = new int[]{5,7,6,9,11,10,8};
		int[] seq1 = new int[]{7,4,6,5};		
		System.out.println(new Offer24().verifySquenceOfBST(seq1));
	}
    

}
