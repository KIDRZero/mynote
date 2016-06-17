package com.liuyong666.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyArray {
	


	/*
	 * �������
	 * 	
	 * 		����һ����������A�������һ���㷨�������Ҫ��������������ĳ��ȡ�
	 * 		����һ����������A�����Ĵ�Сn���뷵�����������ĳ��ȡ�
	 * ����������
	 * 		[1,5,3,4,2,6,7],7
	 * 	���أ�
	 * 		4
	 */

	/**
	 * �����Ҫ��������������ĳ��ȡ�
	 * @param A		��������A
	 * @param n		����A�Ĵ�С
	 * @return		��Ҫ��������������ĳ���
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
     * ������ֵ����
     * 
     * 		����һ������ΪN(N>1)����������A�����Խ�A���ֳ������������֣��󲿷�A[0..K]���Ҳ���A[K+1..N-1]��
     * 		K����ȡֵ�ķ�Χ��[0,N-2]������ô�໮�ַ����У��󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵ������Ƕ��٣�
     * 		������������A������Ĵ�Сn���뷵����Ŀ����Ĵ𰸡�
     * ����������
     * 		[2,7,3,1,1],5
     * ���أ�
     * 		6
     * 
     * ˼·��
     * 		ʱ�临�Ӷ�O(N)������ռ临�Ӷ�O(1)
     * 		������ô�֣����ֵҪô�����Ҫô���ұߣ��������ֵ��Զ�Ǳ�������
     * 		�������ֵ����ߣ���ô���ǵ�������ǽ��Ҳ�����ֵѡ��ľ�����С����ô�ͻ�ֻ��һ��������Ǿ��ǵ�ֻ�������ұߵ�Ԫ��ʱ��
     * 
     * 		ͬ�����ֵ���ұߣ���ô��һ������ֻ���������ģ�
     * 		�������� 2  3  7 1 6�����ֵ��7������2 �Ͱ���2 3��Ч����һ����
     * 		�������ǻ�Ҫ�������ж���ߵĺ��ұߵ��ĸ������ֵ������õĽ�������ô�Ͱ������ַָ����
     */
    /**
     * ������ֵ����
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
     * �ֲ���Сֵλ��
     * 
     * ����ֲ���С�ĸ��arr����Ϊ1ʱ��arr[0]�Ǿֲ���С��
     * arr�ĳ���ΪN(N>1)ʱ�����arr[0]<arr[1]����ôarr[0]�Ǿֲ���С��
     * ���arr[N-1]<arr[N-2]����ôarr[N-1]�Ǿֲ���С��
     * ���0<i<N-1������arr[i]<arr[i-1]����arr[i]<arr[i+1]����ôarr[i]�Ǿֲ���С��
     *  ������������arr����֪arr�������������ڵ���������ȣ�дһ��������ֻ�践��arr������һ���ֲ���С���ֵ�λ�ü��ɡ�
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
     * ���ط�ת
     * 
     * ��һ����NxN�����ʾ��ͼ������ÿ��������һ��int��ʾ��
     * ���дһ���㷨���ڲ�ռ�ö����ڴ�ռ�������(����ʹ�û������)����ͼ��˳ʱ����ת90�ȡ�
     * ����һ��NxN�ľ��󣬺;���Ľ���N,�뷵����ת���NxN����,��֤NС�ڵ���500��ͼ��Ԫ��С�ڵ���256��
     * 
     * 
     */
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
	
	/*
	 * �������
	 * ���дһ���㷨����MxN������ĳ��Ԫ��Ϊ0���������ڵ����������㡣
	 * ����һ��MxN��int[][]����(C++��Ϊvector>)mat�;���Ľ���n��
	 * �뷵����ɲ������int[][]����(C++��Ϊvector>)����֤nС�ڵ���300�������е�Ԫ��Ϊint��Χ�ڡ�
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
