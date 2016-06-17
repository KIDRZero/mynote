package com.liuyong666.offer;

public class Offer38 {
	/*
	 * 数字在排序数组中出现的次数
	 * 题目描述：
	 * 		统计一个数字在排序数组中出现的次数。
	 */

	public int getNumberOfK(int [] array , int k) {
		if(array == null || array.length == 0){
			return 0;
		}
		int firstIndexOfK = getFirstIndexOfK(array, k, 0, array.length - 1);
		int lastIndexOfK  = getLastIndexOfK(array, k, 0, array.length - 1);
		if(firstIndexOfK >= 0 && lastIndexOfK >= 0){
			return lastIndexOfK - firstIndexOfK + 1;
		}
		return 0;
    }

	private int getLastIndexOfK(int[] array, int k, int start, int end) {
		if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(array[mid] == k){
            if(mid == array.length - 1 || (mid + 1 < array.length && array[mid + 1] != k)){
                return mid;
            }else{
                start = mid + 1;
            }
        }else if(array[mid] < k){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
		return getLastIndexOfK(array, k, start, end);
	}

	private int getFirstIndexOfK(int[] array, int k, int start, int end) {
		if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(array[mid] == k){
            if(mid == 0 || (mid - 1 >= 0 && array[mid - 1] != k)){
                return mid;
            }else{
                end = mid - 1;
            }
        }else if(array[mid] < k){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
		return getFirstIndexOfK(array, k, start, end);
	}
}
