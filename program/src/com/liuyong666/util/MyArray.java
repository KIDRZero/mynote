package com.liuyong666.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyArray {
	


	/*
	 * 最短排序
	 * 	
	 * 		对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
	 * 		给定一个整数数组A及它的大小n，请返回最短子数组的长度。
	 * 测试样例：
	 * 		[1,5,3,4,2,6,7],7
	 * 	返回：
	 * 		4
	 */

	/**
	 * 求出需要排序的最短子数组的长度。
	 * @param A		无序数组A
	 * @param n		数组A的大小
	 * @return		需要排序的最短子数组的长度
	 */
    public int findShortest(int[] A, int n) {

    	int left = 0;
    	int max = A[0];
    	for(int i = 1; i < A.length; i++){
    		if(max < A[i]){
    			max = A[i];
    		}
    		if(max > A[i]){
    			left = i;
    		}
    	}

    	
    	int right = 0;
    	int min = A[n - 1];
    	for(int i = n - 2; i >= 0; i--){
    		if(min > A[i]){
    			min = A[i];
    		}
    		if(min < A[i]){
    			right = i;
    		}
    	}
    	int len = left > right ? left - right : right - left;
    	return len == 0 ? 0 : len + 1;
    }
    
    /*
     * 左右最值最大差
     * 
     * 		给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，
     * 		K可以取值的范围是[0,N-2]。求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
     * 		给定整数数组A和数组的大小n，请返回题目所求的答案。
     * 测试样例：
     * 		[2,7,3,1,1],5
     * 返回：
     * 		6
     * 
     * 思路：
     * 		时间复杂度O(N)，额外空间复杂度O(1)
     * 		无论怎么分，最大值要么早左边要么在右边，而且最大值永远是被减数。
     * 		假设最大值在左边，那么我们的任务就是将右侧的最大值选择的尽可能小，那么就会只有一种情况，那就是当只包含最右边的元素时，
     * 
     * 		同理当最大值在右边，那么另一个就是只包含最左侧的，
     * 		类似例子 2  3  7 1 6，最大值是7，包含2 和包含2 3的效果不一样。
     * 		所以我们还要做的是判断左边的和右边的哪个和最大值相减后获得的结果最大，那么就按照那种分割方法。
     */
    /**
     * 左右最值最大差
     * @param A
     * @param n
     * @return
     */
    public int findMaxGap(int[] A, int n) {

    	int max = Integer.MIN_VALUE;  
        for(int i = 0; i < A.length; i++)  
        {  
            if(A[i] > max)
            	max = A[i];  
        }  
              
        return Math.max(max - A[0], max - A[A.length-1]);  
    }
    
    /*
     * 局部最小值位置
     * 
     * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
     * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
     * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
     * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
     *  给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
     */
    
    public int getLessIndex(int[] arr) {

    	if(arr == null || arr.length == 0){
    		return -1;
    	}
    	
    	if(arr.length == 1 || arr[0] < arr[1]){
    		return 0;
    	}
    	
    	if(arr[arr.length - 1] < arr[arr.length - 2]){
    		return arr.length - 1;
    	}
    	
    	int low = 1;
    	int high = arr.length - 2;
    	int mid = 0;
    	while(low < high){
    		mid = low + (high - low) / 2;
    		if(arr[mid] > arr[mid - 1]){
    			high = mid - 1;
    		}else if(arr[mid] > arr[mid + 1]){
    			low = mid + 1;
    		}else{
    			return mid;
    		}
    	}
    	return low;
    	
    }
    
    /*
     * 像素翻转
     * 
     * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，
     * 请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     * 
     * 
     */
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
	
	/*
	 * 清除行列
	 * 请编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与列清零。
	 * 给定一个MxN的int[][]矩阵(C++中为vector>)mat和矩阵的阶数n，
	 * 请返回完成操作后的int[][]矩阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
	 */
	public int[][] clearZero(int[][] mat, int n) {

		boolean[] rowFlag = new boolean[n];
		boolean[] colFlag = new boolean[n];
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				if(mat[i][j] == 0){
					rowFlag[i] = true;
					colFlag[j] = true;
				}
			}
		}
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				if(rowFlag[i] || colFlag[j]){
					mat[i][j] = 0;
				}
			}
		}
		return mat;
    }
	
}
