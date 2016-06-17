package com.liuyong666.util;

import java.util.Collections;

public class MyString {
	public static void main(String[] args) {
		System.out.println(getPalindromeStr("AB1C2EF32X1K1C", "12321"));
		System.out.println(new MyString().trans("Now Co der ", 10));
		System.out.println(new MyString().zipString("welcometonowcoderrrrr"));
	}
	
	public static String getPalindromeStr(String oldStr, String oldPalindromeStr){
		char[] oldArray = oldStr.toCharArray();
		char[] oldPalindromeArray = oldPalindromeStr.toCharArray();
		int n = oldArray.length;
		int m = oldPalindromeArray.length;
		if(n < m){
			throw new RuntimeException("输入错误");
		}
		
		char[] newPalindromeArray = new char[2 * n - m];
		int len = newPalindromeArray.length;
		boolean flag = m % 2 == 0;
		int mid = flag == true ? m / 2 - 1 : m / 2;
		int low = 0;
		int high = n - 1;
		int k = 0;
		for(int i = 0; i <= mid; i++){
			int lowStart = low;
			int highStart = high;
			while(oldArray[low] != oldPalindromeArray[i]){
				low++;
			}
			while(oldArray[high] != oldPalindromeArray[i]){
				high--;
			}
			for(; lowStart < low; k++){
				newPalindromeArray[k] = oldArray[lowStart];
				lowStart++;
			}
			for(; highStart > high; k++){
				newPalindromeArray[k] = oldArray[highStart];
				highStart--;
			}

			newPalindromeArray[k] = oldPalindromeArray[i];
			k++;
			low++;
			high--;
		}
//		if(low <= high){
//			for(int i = low; i <= high; i++ , k++){
//				newPalindromeArray[k] = oldArray[i];
//			}
//		}
		
		int mid2 = len % 2 == 0 ? len / 2 - 1 : len / 2;
		for(int i = mid2 + 1; i < len; i++){
			newPalindromeArray[i] = newPalindromeArray[len - 1 - i];
		}
		return new String(newPalindromeArray);
	}
	
	/*
	 * 字符串变形
	 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。
	 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
	 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
	 * 输入描述:
	 * 		给定一个字符串s以及它的长度n(1≤n≤500)
	 * 输出描述:
	 * 		请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
	 * 输入例子:
	 * 		"This is a sample",16
	 * 输出例子:
	 * 		"SAMPLE A IS tHIS"
	 */
    public String trans(String s, int n) {

    	char[] cArr = s.toCharArray();
    	swap(cArr, 0, n - 1);
    	transLetter(cArr, 0, n - 1);
    	int letterHead = 0;
    	int letterTail = n - 1;
    	for(int i = 1; i < n; i++){
    		if(cArr[i] != ' ' && cArr[i - 1] == ' '){
    			letterHead = i;
    			continue;
    		}
    		if(cArr[i] == ' ' && cArr[i - 1] != ' '){
    			letterTail = i - 1;
    			swap(cArr, letterHead, letterTail);
    		}
    	}
    	if(cArr[n - 1] != ' '){
    		swap(cArr, letterHead, n - 1);
    	}
    	return new String(cArr);
    }

	private void transLetter(char[] cArr, int first, int end) {
		for(int i = first; i <= end; i++){
			if(cArr[i] >= 'A' && cArr[i] <= 'Z'){
				cArr[i] += 32;
			}else if(cArr[i] >= 'a' && cArr[i] <= 'z'){
				cArr[i] -= 32;
			}
		}
		
	}

	private void swap(char[] cArr, int first, int end) {

		while(first < end){
			char temp = cArr[end];
			cArr[end] = cArr[first];
			cArr[first] = temp;
			first++;
			end--;
			
		}
		
	}
	
	/*
	 * 确定字符互异
	 * 
	 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。
	 * 这里我们要求不允许使用额外的存储结构。
	 * 给定一个string iniString，请返回一个bool值,
	 * True代表所有字符全都不同，False代表存在相同的字符。
	 * 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
	 * 
	 */
    public boolean checkDifferent(String iniString) {
        // write code here
        
        if(iniString == null || iniString .length() == 0){
            return true;
        }
        boolean flag = true;
        for(int i = 0; i < iniString.length(); i++){
            for(int j = 0; j < i; j++){
                if(iniString.charAt(j) == iniString.charAt(i)){
                    flag = false;
                }
            }
        }
        
        return flag;
    }
    /*
     * 原串翻转
     * 
     * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
     * 给定一个string iniString，请返回一个string，为翻转后的字符串。
     * 保证字符串的长度小于等于5000。
     */
    public String reverseString(String iniString) {
    	if(iniString == null){
            return null;
        }
        
        String res = "";
        for(int i = iniString.length() - 1; i >= 0; i--){
            res += iniString.charAt(i);
        }
        return res;
    }
    
    /*
     * 确定两串乱序同构
     * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * 这里规定大小写为不同字符，且考虑字符串重点空格。
     * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。
     * 保证两串的长度都小于等于5000。
     */
	public boolean checkSam(String stringA, String stringB) {
	        
	        if(stringA == null || stringB == null || stringA.length() != stringB.length()){
	            return false;
	        }
	        int[] a = new int[128];
	        int[] b = new int[128];
	        boolean flag = true;
	        int len = stringA.length();
	        for(int i = 0; i < len; i++){
	            a[stringA.charAt(i)]++;
	            b[stringB.charAt(i)]++;
	        }
	        for(int i = 0; i < 128; i++){
	            if(a[i] != b[i]){
	                flag = false;
	                break;
	            }
	        }
	        return flag;
	  }
	
	/*
	 * 空格替换
	 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
	 */
	
	public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(iniString.charAt(i) != ' '){
                sb.insert(sb.length() ,iniString.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
	
	/*
	 * 基本字符串压缩
	 * 
	 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
	 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
	 * 给定一个string iniString为待压缩的串(长度小于等于3000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
	 */
	public String zipString(String iniString) {

		if(iniString == null){
			return null;
		}
		if(iniString.length() == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		
		int count = 1;
		sb.append(iniString.charAt(0));
		for(int i = 1; i < iniString.length(); i++){
			if(iniString.charAt(i) == iniString.charAt(i - 1)){
				count++;
			}else{
				sb.append(count);
				count = 1;
				sb.append(iniString.charAt(i));
			}
		}
		sb.append(count);
		if(sb.length() < iniString.length()){
			return sb.toString();
		}else{
			return iniString;
		}
	}
	
	/*
	 * 翻转子串
	 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。
	 * 请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
	 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
	 */
	
	public boolean checkReverseEqual(String s1, String s2) {

		if(s1 == null || s2 == null || s1.length() != s2.length()){
			return false;
		}
		
		return (s1 + s1).contains(s2);
    }

}
