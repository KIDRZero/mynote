package com.liuyong666.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer44 {

	/*
	 * �˿���˳��
	 * ��Ŀ������
	 * 		���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�
	 * 		2~10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С�����Կ����������֡�z
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
