package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class Offer41_2 {
	/*
	 * ��ΪS��������������
	 * ��Ŀ����
	 * 		����һ������s����ӡ�����к�Ϊs��������������(���ٺ�������)
	 * 		��������15������1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ��3����������1~5��4~6��7~8
	 * �������:
	 * 		������к�ΪS�������������С�
	 * 		�����ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
	 */
	
	public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
	    if(sum < 3){
	    	return list;
	    }
        int low = 1;
        int high = 2;
        //��ǰ�ܺ�С��sum������£�low�����ӵ�sum��һ��϶������sum
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
