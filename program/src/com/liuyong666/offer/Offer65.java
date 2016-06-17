package com.liuyong666.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Offer65 {

	/*
	 * �������ڵ����ֵ
	 * ��Ŀ����
	 * 		����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
	 * 		���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
	 * 		��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
	 * 		 �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
	 * 			 {[2,3,4],2,6,2,5,1}�� 
	 * 				{2,[3,4,2],6,2,5,1}�� 
	 * 				{2,3,[4,2,6],2,5,1}�� 
	 * 				{2,3,4,[2,6,2],5,1}�� 
	 * 				{2,3,4,2,[6,2,5],1}��
	 * 				 {2,3,4,2,6,[2,5,1]}��
	 */
	   public ArrayList<Integer> maxInWindows(int[] num, int size) {
	        ArrayList<Integer> maxList = new ArrayList<Integer>();
	        if(size <= 0) return maxList;
	        //����һ��˫�˶��б���ÿ���������ڵ����ֵ���±�
	        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	        //����һ������start���ڼ�¼��ǰ�������ڵ����ֵ���±�
	        int start = 0;
	        for (int i = 0; i < num.length; i++) {
	            start = i + 1 - size;//��start���ڵ�ʱ���ʾ��һ�������Ѿ��������ƶ���
	            if(queue.isEmpty()){
	                queue.add(i);
	            }else if(start > queue.peekFirst()){//���������ʾ��ǰ����start��ֵ����һ�����ڵ�start����
	                queue.pollFirst();
	            }
	            
	            while(!queue.isEmpty() && num[queue.peekLast()] <= num[i]){
	                //���������ʾ�����ж�βλ�ö�Ӧ��Ԫ�رȵ�ǰԪ�ظ�С�����Ƴ�������Ϊ��Ҫ�õ����Ǵ������ֵ
	                queue.pollLast();
	            }
	            queue.add(i);
	            if(start >= 0){
	                //ʵ���ϵ�start=0��ʱ��ڵ�һ���������ڣ���ʱ�����б�����ǵ�һ�������������ֵ���±ֱ꣬����Ӿ���
	                maxList.add(num[queue.peekFirst()]);
	            }
	        }
	        return maxList;
	    }
	    
}
