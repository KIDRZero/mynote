package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer55 {
	/*
	 * �ַ����е�һ�����ظ����ַ�
	 * ��Ŀ����
	 * 		��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
	 * 		���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
	 * 		���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"�� 
	 * �������:
	 * 		�����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
	 */
	List<Character> stringstream = new ArrayList<>();
    Set<Character> rep = new HashSet<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(stringstream.contains(ch)){
            rep.add(ch);
        }
        stringstream.add(ch);
        
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    
        for(int i = 0; i < stringstream.size(); i++){
            char ch = stringstream.get(i);
			if(!rep.contains(ch)){
                return ch;
            }
        }
        return '#';
    }

}
