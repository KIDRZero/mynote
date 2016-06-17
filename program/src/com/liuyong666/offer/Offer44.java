package com.liuyong666.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer44 {

	/*
	 * 扑克牌顺子
	 * 题目描述：
	 * 		从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
	 * 		2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。z
	 */
	public boolean isContinuous(int [] numbers) {

        if(numbers == null || numbers.length == 0){
            return false;
        }
        
        boolean hasNonZore = false;
        int min = 14;
        int max = -1;
        Set<Integer> set = new HashSet<>();
        int len = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != 0){
                len++;
                set.add(numbers[i]);
                hasNonZore = true;
                if(numbers[i] < min){
                    min = numbers[i];
                }
                if(numbers[i] > max){
                    max = numbers[i];
                }
            }
        }
        int diff = min - max >= 0 ? min - max : max - min;
        if(len == set.size() && hasNonZore && diff <= numbers.length - 1){
            return true;
        }
        return false;
	}
}
