package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer55 {
	/*
	 * 字符流中第一个不重复的字符
	 * 题目描述
	 * 		请实现一个函数用来找出字符流中第一个只出现一次的字符。
	 * 		例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
	 * 		当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
	 * 输出描述:
	 * 		如果当前字符流没有存在出现一次的字符，返回#字符。
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
