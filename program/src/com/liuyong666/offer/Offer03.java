package com.liuyong666.offer;

public class Offer03 {

	/**
	 * ��ά�����еĲ���
	 * 
	 * ��Ŀ����
	 * 		��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
	 * 		�����һ������������������һ����ά�����һ���������ж��������Ƿ��и������� 
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
