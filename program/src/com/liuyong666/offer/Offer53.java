package com.liuyong666.offer;

public class Offer53 {
	/*
	 * 正则表达式匹配
	 * 题目描述：
	 * 		请实现一个函数用来匹配包括'.'和'*'的正则表达式。
	 * 		模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
	 * 		 在本题中，匹配是指字符串的所有字符匹配整个模式。
	 * 		例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
	 */
    public boolean match(char[] str, char[] pattern)
    {
    	if(str == null || pattern == null){
    		return false;
    	}
    	return matchRegCore(str, 0, str.length, pattern, 0, pattern.length);
        
    }

	private boolean matchRegCore(char[] str, int i, int len1, char[] pattern, int j, int len2) {
		if(i == len1 && j == len2){
			//主串匹配到末尾，模式串要么当前位置的字符是*，否则返回false
			if(j == len2 || pattern[j] == '*'){
				return true;
			}else{
				return false;
			}
		}
		
		if(i != len1 && j == len2){
			return false;
		}
		/*
         * 一、如果模式串的下一个字符是*， 1.1 并且模式串的当前字符能与主串的字符进行匹配，则可能出现三种情况：
         * 1、模式串的当前字符匹配到0个字符，则主串不变，模式穿移动到两个字符
         * 2、模式穿的当前字符匹配到1个字符，则主串移动一个位置，模式串移动两个位置
         * 3、模式串的当前字符匹配到多个字符，则主串移动一个位置，模式串移动两个位置。 1.2 如果不能匹配的话: 主串不变，模式串移动两个位置；
         * 二、如果下一个字符不是*，则进行逐个字符进行匹配 三、如果模式串的下一个字符是.，则就进行一个字符的匹配
         */
		if(j + 1 < len2 && pattern[j + 1] == '*'){
			if(i < len1 && (pattern[j] == str[i] || pattern[j] == '.')){
				return matchRegCore(str, i + 1, len1, pattern, j, len2) || matchRegCore(str, i + 1, len1, pattern, j + 2, len2) || matchRegCore(str, i, len1, pattern, j + 2, len2);
			}else{
				return matchRegCore(str, i, len1, pattern, j + 2, len2);
			}
		}
		
		if(i < len1 && (str[i] == pattern[j] || pattern[j] == '.')){
			return matchRegCore(str, i + 1, len1, pattern, j + 1, len2);
		}
		return false;
	}
}
