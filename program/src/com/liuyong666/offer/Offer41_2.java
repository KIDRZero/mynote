package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class Offer41_2 {
	/*
	 * 和为S的连续正数序列
	 * 题目描述
	 * 		输入一个正数s，打印出所有和为s的连续正数序列(至少含两个数)
	 * 		例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1~5、4~6、7~8
	 * 输出描述:
	 * 		输出所有和为S的连续正数序列。
	 * 		序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 */
	
	public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
	    if(sum < 3){
	    	return list;
	    }
        int low = 1;
        int high = 2;
        //当前总和小于sum的情况下，low在增加到sum的一半肯定会大于sum
        int mid = (sum + 1) / 2;
        int curSum = low + high;
        while(low < mid){
            if(curSum == sum){
				list.add(getSeq(low,high));
            }
            while(low < mid && curSum > sum){
                curSum -= low;
                low++;
                if(curSum == sum){
					list.add(getSeq(low,high));
           	 	}
            }
            high++;
            curSum += high;
        }
        return list;
        
    }
    
    private ArrayList<Integer> getSeq(int low, int high){
		ArrayList<Integer> seq = new ArrayList<>();
        for(int i = low; i <= high; i++){
            seq.add(i);
        }
        return seq;
    }
    
    public static void main(String[] args) {
		System.out.println(new Offer41_2().findContinuousSequence(3));
	}
	

}
