package com.liuyong666.offer;

public class Offer08 {
	
	/*
	 * 题目描述
	 * 		把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 		输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
	 * 		例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 */
	public int search(int[] array){
        //当数组为空或者长度为0的时候返回0
        if(array == null || array.length <=0){
            return 0;
        }
        //数组不为空且数组的长度大于0
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while(array[low] >= array[high]){
            //两个元素
            if(high - low == 1){
                return array[high];
            }
            //多于两个元素
            mid = (low + high)/2;
            //low、mid和high位置的元素都相同
            if(array[low] == array[high] && array[mid] == array[high]){
                //顺序查找
                return orderSearch(array,low,high);
            }
            //如果中间位置的值大于array[low]的值，说明最小值在a[mid]的右边
            if(array[mid] >= array[low]){
                low = mid;
            }else if(array[mid] <= array[high]){
                high = mid;
            }
        }
       return array[mid];
    }
    
    //顺序查找
    private int orderSearch(int[] array, int low, int high) {
        int result = array[low];
        for(int i = low + 1; i <= high;i++){
            if(result > array[i]){
                result = array[i];
            }
        }
        return result;
    }
	

}
