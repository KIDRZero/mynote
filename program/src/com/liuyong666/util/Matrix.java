package com.liuyong666.util;

public class Matrix {
	
	/**
	 * ˳ʱ���ӡ�����һȦ	
	 * @param array		��������
	 * @param startRow	��Ҫ��ӡ��Ȧ����ʼ�к�
	 * @param startCol	��Ҫ��ӡ��Ȧ����ʼ�к�
	 * @param endRow	��Ҫ��ӡ��Ȧ����ֹ�к�
	 * @param endCol	��Ҫ��ӡ��Ȧ����ֹ�к�
	 */
	public static void printMatrixInCircle(int array[][], int startRow, int startCol, int endRow, int endCol){
		
		int i = startCol;
		while(i <= endCol){
			System.out.print(array[startRow][i] + " ");
			i++;
		}
		
		i = startRow + 1;
		while(i <= endRow){
			System.out.print(array[i][endCol] + " ");
			i++;
		}
		
		i = endCol - 1;
		while(endRow > startRow && i >= startCol ){
			System.out.print(array[endRow][i] + " ");
			i--;
		}
		
		i = endRow - 1;
		while(endRow - 1 > startRow && i > startRow){
			System.out.print(array[i][startCol] + " ");
			i--;
		}
	}
	/**
	 * ˳ʱ���ӡ����
	 * @param array 	Ҫ��ӡ��ԭ����
	 */
	public static void printMatrixClockwisely(int array[][]){
		int rows = array.length;
		for(int i = 1; i < rows; i++){
			if(array[i].length != array[i - 1].length){
				System.out.println("���󲻺Ϸ�");
			}
		}
		int cols = array[0].length;
		/*
		 * ά���ĸ��������������Ͻ��к��кź����½��к��к�
		 * ÿ��ӡһȦ���ĸ�����ͬʱ������
		 */
		int startRow = 0;
		int startCol = 0;
		int endRow = rows - 1;
		int endCol = cols - 1;
		while(startRow <= endRow && startCol <= endCol){
			printMatrixInCircle(array, startRow, startCol, endRow, endCol);
			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
	}
	/**
	 * ˳ʱ����ת����
	 * @param array
	 */
	public static void rotateMatrixClockwisely(int array[][]){
		//������
		int rows = array.length;
		for(int i = 1; i < rows; i++){
			if(array[i].length != rows){
				System.out.println("���󲻺Ϸ�");
			}
		}
		/*
		 * ά����������
		 * start Ϊ��תȦ���Ͻ�λ��
		 * end   Ϊ��תȦ���½�λ��
		 */
		int start = 0;
		int end = rows - 1;
		while(start < end){
			rotateMatrixInCircle(array, start, end);
			start++;
			end--;
		}
	}
	
	/**
	 * ��������תһȦ
	 * @param array		��������
	 * @param start		��תȦ��ʼλ��
	 * @param end		��תȦ����λ��
	 */
	public static void rotateMatrixInCircle(int array[][], int start, int end){
		for(int i = start; i < end; i++){
			int offset = i -start;
			int temp = array[start][i];
			array[start][i] = array[end - offset][start];
			array[end - offset][start] = array[end][end - offset];
			array[end][end - offset] = array[i][end];
			array[i][end] = temp;
		}
		
		
	}
	
	/**
	 * �����Ͻ�б�Ŵ�ӡ������
	 * @param array
	 */
	public static void printMatrixobliquely(int array[][]){
		//������
		int rows = array.length;
		for(int i = 1; i < rows; i++){
			if(array[i].length != rows){
				System.out.println("���󲻺Ϸ�");
			}
		}
		/*
		 * ά������λ�ã��ĸ�����
		 * ��ֱ����ָ������
		 * ˮƽ����ָ������
		 * ���ǵ�����Ϊһ��б��
		 */
		int startRow = 0;
		int startCol = 0;
		int endRow = 0;
		int endCol = 0;
		
		while(startRow <= rows - 1 && startCol <= rows - 1 && endRow <= rows - 1 && endCol <= rows - 1){
			printObliqueLine(array, startRow, startCol, endRow, endCol);
			if(startCol < rows - 1 || endRow < rows - 1){
				startCol++;
				endRow++;
			}else{
				startRow++;
				endCol++;
			}
		}
		
		
	}
	
	/**
	 * ��ӡ�����һ��б��
	 * @param array		ԭ����
	 * @param startRow	б����ʼ��ĺ�����
	 * @param startCol	б����ʼ���������
	 * @param endRow	б����ֹ��ĺ�����
	 * @param endCol	б����ֹ���������
	 */
	public static void printObliqueLine(int array[][], int startRow, int startCol, int endRow, int endCol){
		//��ӡб�ߺ���ݼ�
		for(int i = startRow , j = startCol; i <= endRow && j >= endCol; i++ , j--){
			System.out.print(array[i][j] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[][] aa = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//		printObliqueLine(aa, 0, 4, 4, 0);
		printMatrixClockwisely(aa);
		printMatrixobliquely(aa);
		int[][] aaa = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotateMatrixClockwisely(aa);
		System.out.println();
		for(int i = 0; i < aa.length; i++){
			for(int j = 0; j < aa[i].length; j++){
				System.out.print(aa[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
//		printObliqueLine(aa, 0, 4, 4, 0);
		printMatrixobliquely(aa);
		
	}

}
