package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer64 {
	/*
	 * �������е���λ��
	 * ��Ŀ����
	 * 		��εõ�һ���������е���λ����
	 * 		������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
	 * 		������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
	 */

	//���ı�ԭ�������Ľⷨ
	List<Integer> dataStream = new ArrayList<>();
    List<Integer> sortStream = new ArrayList<>();
    public void Insert(Integer num) {
        dataStream.add(num);
        sortStream.add(num);
        Collections.sort(sortStream);
    
    }

    public Double GetMedian() {
        int size = sortStream.size();
        if(size == 0){
            return Double.NaN;
        }
        int midIndex = size / 2;
        double mid = (size & 1) == 1 ? (double)sortStream.get(midIndex) : (sortStream.get(midIndex) + sortStream.get(midIndex - 1)) / 2.0;
        return mid;
    }
    
    //�ı�ԭ�������Ľⷨ
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void Insert1(Integer num) {
        int index = 0;
        int size = list.size();
        while (index < size) {
            if (num <= list.get(index))
                break;
            index++;
        }
        list.add(index, num);
    }

    public Double GetMedian1() {
        int size = list.size();
        if ((size & 1) == 0)
            return (double) ((list.get(size / 2) + list.get(size / 2 - 1)) / 2.0);
        return (double)list.get(size / 2) * 1.0;
    }
    
    
}
