package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer64 {
	/*
	 * 数据流中的中位数
	 * 题目描述
	 * 		如何得到一个数据流中的中位数？
	 * 		如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
	 * 		如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
	 */

	//不改变原数据流的解法
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
    
    //改变原数据流的解法
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
