package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Offer30 {
	/*
	 * 最小的K个数
	 * 
	 * 题目描述
	 * 		输入n个整数，找出其中最小的K个数。
	 * 		例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 */
	/*
	 * 解法1：
	 * 思路：
	 * 		对数组排序，去前边k个数存到list集合中
	 * 		该解法时间复杂度依赖于排序
	 */
    public ArrayList<Integer> getLeastNumbers_Solution1(int [] input, int k) {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || input.length < k || k <= 0){
    		return list;
    	}
        Arrays.sort(input);
        for(int i = 0; i < k; i++){
        	list.add(input[i]);
        }
    	return list;
    }
    
    /*
     * 解法2
     * 思路：
     * 		基于partition函数
     * 		只有当我们可以修改输入的数组时可用
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || input.length < k || k <= 0){
    		return list;
    	}
    	int start = 0;
    	int end = input.length - 1;
    	int index = partition(input, start, end);
    	while(index != k - 1){
    		if(index > k - 1){
    			end = index - 1;
    			index = partition(input, start, end);
    		}else{
    			start = index + 1;
    			index = partition(input, start, end);
    		}
    	}
    	for(int i = 0; i < k; i++){
        	list.add(input[i]);
        }
    	return list;
    }
    private int partition(int[] input, int low, int high) {
		int pivotKey = input[low];
		while(low < high){
			while(low < high && input[high] >= pivotKey){
				high--;
			}
			input[low] = input[high];
			while(low < high && input[low] <= pivotKey){
				low++;
			}
			input[high] = input[low];
		}
		input[low] = pivotKey;
		return low;
	}
    
    /*
     * 适合海量数据的处理
     * 		创建一个用于保存最小k个数的容器，第一步是放入k个元素，
     * 		第二步是比较容器中最大的数与当前数组遍历的那个数的大小，
     * 		如果容器中最大的数比当前遍历的数大，就移除该数，并放入当前遍历的那个数。
     * 
     * 		最大堆  或红黑树都能实现这样的容器
     */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || input.length < k || k <= 0){
    		return list;
    	}
    	TreeSet<Integer> s = new TreeSet<Integer>();
    	for(int i = 0; i < input.length; i++){
    		if(s.size() < k){
    			s.add(input[i]);
    		}else{
    			if(input[i] < s.last()){
    				s.remove(s.last());
    				s.add(input[i]);
    			}
    		}
    	}
    	Iterator<Integer> it = s.iterator();
    	while(it.hasNext()){
    		list.add(it.next());
    	}
    	return list;
    }
	public static void main(String[] args) {
		System.out.println(new Offer30().GetLeastNumbers_Solution2(new int[]{4,5,1,6,2,7,3,8}, 4));
	}

}
