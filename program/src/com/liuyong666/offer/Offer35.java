package com.liuyong666.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer35 {
	/*
	 * ��һ��ֻ����һ�ε��ַ�λ��
	 * 
	 * ��Ŀ������
	 * 		��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ���λ�á�
	 * 		��Ϊ�մ�������-1��λ��������0��ʼ
	 * ˼·��
	 * 		���ù�ϣ��������ַ����ֵĴ���
	 */

	public int firstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            Character ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
        
    }
}
