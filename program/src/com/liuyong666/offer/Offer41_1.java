package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer41_1 {
	/*
	 * ��ΪS�����������ҳ˻���С
	 * ��Ŀ����
	 * 		����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
	 * 		����ж�����ֵĺ͵���S������������ĳ˻���С�ġ� 
	 * �������:
	 * 		��Ӧÿ�����԰����������������С���������
	 */
	public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length < 2){
            return list;
        } 
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            int curSum = array[low] + array[high];
            if(curSum == sum){
                //���������ǵ�������ģ����Ե�һ���ҵ������Կ϶��ǳ˻���С�ġ�
                //���磬1+4=2+3������ӵ�һ��λ�ÿ�ʼ�ҵĻ�����Ȼ1��4�ĳ˻�����С��
                list.add(array[low]);
                list.add(array[high]);
                break;
            }else if(curSum > sum){
                high--;
            }else{
                low++;
            }
        }
        return list;
        
    }

}
