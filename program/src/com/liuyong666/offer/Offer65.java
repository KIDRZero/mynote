package com.liuyong666.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Offer65 {

	/*
	 * 滑动窗口的最大值
	 * 题目描述
	 * 		给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
	 * 		例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
	 * 		那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
	 * 		 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
	 * 			 {[2,3,4],2,6,2,5,1}， 
	 * 				{2,[3,4,2],6,2,5,1}， 
	 * 				{2,3,[4,2,6],2,5,1}， 
	 * 				{2,3,4,[2,6,2],5,1}， 
	 * 				{2,3,4,2,[6,2,5],1}，
	 * 				 {2,3,4,2,6,[2,5,1]}。
	 */
	   public ArrayList<Integer> maxInWindows(int[] num, int size) {
	        ArrayList<Integer> maxList = new ArrayList<Integer>();
	        if(size <= 0) return maxList;
	        //创建一个双端队列保存每个滑动窗口的最大值得下标
	        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	        //创建一个变量start用于记录当前滑动窗口的最大值的下标
	        int start = 0;
	        for (int i = 0; i < num.length; i++) {
	            start = i + 1 - size;//当start大于的时候表示第一个窗口已经不能再移动了
	            if(queue.isEmpty()){
	                queue.add(i);
	            }else if(start > queue.peekFirst()){//这个条件表示当前窗口start的值比上一个窗口的start更大
	                queue.pollFirst();
	            }
	            
	            while(!queue.isEmpty() && num[queue.peekLast()] <= num[i]){
	                //这种情况表示，队列队尾位置对应的元素比当前元素更小，就移除他，因为需要得到的是窗口最大值
	                queue.pollLast();
	            }
	            queue.add(i);
	            if(start >= 0){
	                //实际上当start=0的时候第第一个滑动窗口，这时队列中保存的是第一个滑动窗口最大值的下标，直接添加就行
	                maxList.add(num[queue.peekFirst()]);
	            }
	        }
	        return maxList;
	    }
	    
}
