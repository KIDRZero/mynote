package com.liuyong666.offer;

public class Offer03 {

	/**
	 * 二维数组中的查找
	 * 
	 * 题目描述
	 * 		在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 		请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
	 */
    public boolean find(int [][] array,int target) {

    	int rowIndex = 0;
    	int colIndex = array[0].length - 1;
    	while(rowIndex < array.length && colIndex >= 0){
    		if(target < array[rowIndex][colIndex]){
    			colIndex--;
    		}else if(target > array[rowIndex][colIndex]){
    			rowIndex++;
    		}else{
    			return true;
    		}
    		
    	}
    	return false;
    }	
}
