package com.liuyong666.offer;

import java.util.ArrayList;

public class Offer20 {
	/*
	 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
	 * ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	 *  �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 *  ����:
	 *  ��Ϊÿ��ӡһȦ����ı���ʼ���꣬������Ҫ��ȷ�������С����ʼ����Ĺ�ϵ
	 *  ����4�׾��󣬵�һȦ��ʼ����Ϊ(0,0)���ڶ�Ȧ��ʼ����Ϊ(1,1)����ӡ��Ȧ֮��ͽ����ˡ�
	 *  ����һ��5�׾���ǰ��Ȧͬ4�ף�����ȦΪ(2,2)������ֻ��ӡ��һ������
	 *  �ᷢ�֣�ֻҪ��ʼ���������С�ڽ������ͻ�һֱתȦ��ӡ
	 *  ����ֹͣתȦ��ӡ������������ʼ�����2�����ڻ��ߵ��ڽ���
	 *  
	 *  Ȼ����ÿһȦ�Ĵ�ӡ������
	 *  ��һ��:�����Ҵ�ӡһ��
	 *  �ڶ��������ϵ��´�ӡһ�У���������ֹ�кŴ�����ʼ�кţ�
	 *  �����������ҵ����ӡһ�У���������ֹ�кŴ�����ʼ�кŵ�ͬʱ����ֹ�кŴ�����ʼ�кţ�
	 *  ���Ĳ������µ��ϴ�ӡһ�У���������ֹ�кű���ʼ�кŴ�2����ֹ�кŴ�����ʼ�кţ�
	 *  ע�⣺��ӡ����������һȦ����ֻ��Ҫ����������������һ��
	 */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        
    	if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
    		return null;
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	//�������
    	int start = 0;
    	
    	while(rows > 2 * start && cols > 2 * start){
    		printMatrixInCircle(list,matrix,rows,cols,start);
    		start++;
    	}
    	
    	return list;
    }

    /**
     * ��ӡÿһȦ
     * @param list		���صļ���
     * @param matrix	����
     * @param rows		����
     * @param cols		����
     * @param start		�������
     */
	private void printMatrixInCircle(ArrayList<Integer> list, int[][] matrix, int rows, int cols, int start) {
		
		//endXΪ��ֹ�кţ�endYΪ��ֹ�к�
		int endX = rows - start - 1;
		int endY = cols - start - 1;
		
		//�����ҵ�һ��
		for(int i = start; i <= endY; i++){
			list.add(matrix[start][i]);
		}
		
		//���ϵ��µ�һ��
		if(endX > start){
			for(int i = start + 1; i <= endX; i++){
				list.add(matrix[i][endY]);
			}
		}
		
		//���ҵ����һ��
		if(endX > start && endY > start){
			for(int i = endY - 1; i >= start; i--){
				list.add(matrix[endX][i]);
			}
		}
		
		//���µ��ϵ�һ��
		if(endX - 1 > start && endY > start){
			for(int i = endX - 1; i >= start + 1; i--){
				list.add(matrix[i][start]);
			}
		}
		
		
	}	

}
