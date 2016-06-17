package com.liuyong666.offer;

public class Offer04 {
	
	/**
	 * 题目描述
	 * 		请实现一个函数，将一个字符串中的空格替换成“%20”。
	 * 		例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 */
    public String replaceSpace(StringBuffer str) {
    	String s = str.toString();
    	//统计空格数
    	int blank_count = getBlankNum(s);
    	//获取原来的字符串长度
    	int oldStrLen = s.toCharArray().length;
    	//计算替换空格后需要的长度
    	int newStrLen = oldStrLen + blank_count * 2;
    	char[] newArray = new char[newStrLen];
    	//把原来字符串复制到newArray数组中
    	System.arraycopy(s.toCharArray(), 0, newArray, 0, oldStrLen);
    	int oldStrIndex = oldStrLen - 1;
    	int newStrIndex = newStrLen - 1;
    	//当oldStrIndex == newStrIndex时替换完毕
    	while(oldStrIndex >= 0 && oldStrIndex != newStrIndex){
    		if(newArray[oldStrIndex] == ' '){
    			newArray[newStrIndex--] = '0';
    			newArray[newStrIndex--] = '2';
    			newArray[newStrIndex--] = '%';
    		}else{
    			newArray[newStrIndex--] = newArray[oldStrIndex];
    		}
    		oldStrIndex--;
    	}
    	return new String(newArray);
    }

	private int getBlankNum(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				count++;
			}
		}
		return count;
	}
}
