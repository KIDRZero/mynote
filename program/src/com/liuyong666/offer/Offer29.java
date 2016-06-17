package com.liuyong666.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer29 {
	/*
	 * �����г��ִ�������һ�������
	 * 
	 * ��Ŀ����
	 * 		��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	 * 		��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
	 * 		��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
	 */
	public static void main(String[] args) {
		int a = new Offer29().moreThanHalfNum(new int[]{1,2,3,2,2,2,5,4,2});
		System.out.println(a);
	}
    public int moreThanHalfNum(int [] array) {
     
    	if(array == null || array.length == 0){
    		return 0;
    	}
    	int flag = 0;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int len = array.length;
    	for(int i = 0; i < len; i++){
    		if(map.containsKey(array[i])){
    			map.put(array[i], map.get(array[i]) + 1);
    		}else{
    			map.put(array[i], 1);
    		}
    		if(map.get(array[i]) > len / 2){
    			flag = array[i];
    			break;
    		}
    	}
    	return flag;
    }
    /*
     * ˼·2��
     * 		������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬��ô�����ֳ��ֵĴ���һ�������������ֳ��ִ���֮��
     * 		���ñ�ʶ������������ͬ�����֣��ͰѴ�����1�����û�������ͰѴ�����1
     * 		���ִ�������һ������ֿ϶������һ�ΰ�times������Ϊ1��Ӧ������
     * 		��һ�����˵����ӣ�����������������֮���������֣���ʱtimes����Ӧ����һ����ֵ�ˣ�
     * 		��ô�������ֵĳ��ִ�����ǰ���������ֵĳ��ִ�����ȵ�ʱ��times������Ϊ0��
     * 		�������������һ�룬��ô�ñ��������¸�ֵΪ1�����Ծ��ҵ��˸����֡�
     * 
     * 		������һ�����ֵĴ�������һ�룬�����Ǹ�����
     * 		�϶������һ�ΰ�times������Ϊ1��Ӧ������
     * 
     * 		һ��ɾ��������ͬ����
     */
    public int moreThanHalfNum1(int[] array) {
    	if(array == null || array.length == 0){
    		return 0;
    	}
    	int times = 1;
    	int result = array[0];
    	for(int i = 1; i < array.length; i++){
    		if(times == 0){
    			result = array[i];
    			times = 1;
    		}else if(array[i] == result){
    			//������ͬ�����ִ���������1
    			times++;
    		}else{
    			//û��������ͬ�ľͰѴ�����1
    			times--;
    		}
    	}
    	if(!checkMoreThanHalfNum(array, result)){
    		return 0;
    	}
    	return result;
    }
    //���������Ƿ���ֵĴ�������һ��
    private boolean checkMoreThanHalfNum(int[] array, int result){
    	int times = 0;
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == result){
    			times++;
    		}
    	}
    	boolean isMoreThanHalf = true;
    	if(times * 2 <= array.length){
    		isMoreThanHalf = false;
    	}
    	return isMoreThanHalf;
    }

}
