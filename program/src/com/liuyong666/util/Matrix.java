package com.liuyong666.util;

public class Matrix {
	
	/**
	 * 顺时针打印矩阵的一圈	
	 * @param array		矩阵数组
	 * @param startRow	需要打印的圈的起始行号
	 * @param startCol	需要打印的圈的起始列号
	 * @param endRow	需要打印的圈的终止行号
	 * @param endCol	需要打印的圈的终止列号
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
	 * 顺时针打印矩阵
	 * @param array 	要打印的原矩阵
	 */
	public static void printMatrixClockwisely(int array[][]){
		int rows = array.length;
		for(int i = 1; i < rows; i++){
			if(array[i].length != array[i - 1].length){
				System.out.println("矩阵不合法");
			}
		}
		int cols = array[0].length;
		/*
		 * 维护四个变量，矩阵左上角行号列号和右下角行号列号
		 * 每打印一圈，四个变量同时往里缩
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
	 * 顺时针旋转矩阵
	 * @param array
	 */
	public static void rotateMatrixClockwisely(int array[][]){
		//正矩阵
		int rows = array.length;
		for(int i = 1; i < rows; i++){
			if(array[i].length != rows){
				System.out.println("矩阵不合法");
			}
		}
		/*
		 * 维护两个变量
		 * start 为旋转圈左上角位置
		 * end   为旋转圈右下角位置
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
	 * 正矩阵旋转一圈
	 * @param array		矩阵数组
	 * @param start		旋转圈起始位置
	 * @param end		旋转圈结束位置
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
	 * 从左上角斜着打印正矩阵
	 * @param array
	 */
	public static void printMatrixobliquely(int array[][]){
		//正矩阵
		int rows = array.length;
		for(int i = 1; i < rows; i++){
			if(array[i].length != rows){
				System.out.println("矩阵不合法");
			}
		}
		/*
		 * 维护两个位置，四个变量
		 * 竖直方向指针坐标
		 * 水平方向指针坐标
		 * 他们的连线为一条斜线
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
	 * 打印矩阵的一条斜线
	 * @param array		原矩阵
	 * @param startRow	斜线起始点的横坐标
	 * @param startCol	斜线起始点的纵坐标
	 * @param endRow	斜线终止点的横坐标
	 * @param endCol	斜线终止点的纵坐标
	 */
	public static void printObliqueLine(int array[][], int startRow, int startCol, int endRow, int endCol){
		//打印斜线横加纵减
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
