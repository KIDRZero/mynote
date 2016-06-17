package com.liuyong666.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GetRepeatMost {
	public static void main(String[] args) {
		int a[] = {1,5,4,3,4,4,5,4,5,5,6,6,6,6,6,};
		System.out.println(getRepeatMost(a));
	}
	
	//�ҳ��������ظ�������
	public static int getRepeatMost(int a[]){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		//��¼ÿ��Ԫ�س��ֵĴ���
		for(int i = 0;i < a.length;i++){
			if(map.containsKey(a[i])){
				map.put(a[i], map.get(a[i])+1);
			}else{
				map.put(a[i], 1);
			}
		}
		
		//�ҳ����ִ�������Ԫ��
		int most = 0;
		int result = 0;
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			Integer key = it.next();
			Integer value = map.get(key);
			if(value > most){
				most = value;
				result = key;
			}
		}
		
		
		return result;
	}
	

}
