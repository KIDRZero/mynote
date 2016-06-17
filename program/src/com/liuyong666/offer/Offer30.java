package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Offer30 {
	/*
	 * ��С��K����
	 * 
	 * ��Ŀ����
	 * 		����n���������ҳ�������С��K������
	 * 		��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
	 */
	/*
	 * �ⷨ1��
	 * ˼·��
	 * 		����������ȥǰ��k�����浽list������
	 * 		�ýⷨʱ�临�Ӷ�����������
	 */
    public ArrayList<Integer> getLeastNumbers_Solution1(int [] input, int k) {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || input.length < k || k <= 0){
    		return list;
    	}
        Arrays.sort(input);
        for(int i = 0; i < k; i++){
        	list.add(input[i]);
        }
    	return list;
    }
    
    /*
     * �ⷨ2
     * ˼·��
     * 		����partition����
     * 		ֻ�е����ǿ����޸����������ʱ����
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || input.length < k || k <= 0){
    		return list;
    	}
    	int start = 0;
    	int end = input.length - 1;
    	int index = partition(input, start, end);
    	while(index != k - 1){
    		if(index > k - 1){
    			end = index - 1;
    			index = partition(input, start, end);
    		}else{
    			start = index + 1;
    			index = partition(input, start, end);
    		}
    	}
    	for(int i = 0; i < k; i++){
        	list.add(input[i]);
        }
    	return list;
    }
    private int partition(int[] input, int low, int high) {
		int pivotKey = input[low];
		while(low < high){
			while(low < high && input[high] >= pivotKey){
				high--;
			}
			input[low] = input[high];
			while(low < high && input[low] <= pivotKey){
				low++;
			}
			input[high] = input[low];
		}
		input[low] = pivotKey;
		return low;
	}
    
    /*
     * �ʺϺ������ݵĴ���
     * 		����һ�����ڱ�����Сk��������������һ���Ƿ���k��Ԫ�أ�
     * 		�ڶ����ǱȽ��������������뵱ǰ����������Ǹ����Ĵ�С��
     * 		����������������ȵ�ǰ���������󣬾��Ƴ������������뵱ǰ�������Ǹ�����
     * 
     * 		����  ����������ʵ������������
     */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || input.length < k || k <= 0){
    		return list;
    	}
    	TreeSet<Integer> s = new TreeSet<Integer>();
    	for(int i = 0; i < input.length; i++){
    		if(s.size() < k){
    			s.add(input[i]);
    		}else{
    			if(input[i] < s.last()){
    				s.remove(s.last());
    				s.add(input[i]);
    			}
    		}
    	}
    	Iterator<Integer> it = s.iterator();
    	while(it.hasNext()){
    		list.add(it.next());
    	}
    	return list;
    }
	public static void main(String[] args) {
		System.out.println(new Offer30().GetLeastNumbers_Solution2(new int[]{4,5,1,6,2,7,3,8}, 4));
	}

}
