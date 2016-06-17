package com.liuyong666.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer51 {

	/*
	 * �������ظ�������
	 * ��Ŀ����
	 * 		��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
	 * 		Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� 
	 * 		���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3��
	 */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    
        if(numbers == null || numbers.length <= 1 || duplication == null){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < length; i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }
}
