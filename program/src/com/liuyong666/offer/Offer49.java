package com.liuyong666.offer;

public class Offer49 {
	/*
	 * ���ַ���ת��������
	 * ��Ŀ����
	 * 		��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯����
	 */
	boolean isValid = true;
	public int StrToInt(String str) {
		if(str == null || str.length() == 0 || (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-'))){
			isValid = false;
            return 0;
        }
        boolean isFu = false;
        int num = 0;
        for(int i = 0; i < str.length(); i++){
            char digit = str.charAt(i);
            if(i == 0 && (digit == '+' || digit == '-')){
                if(digit == '-'){
                    isFu = true;
                }
                continue;
            }
            if(digit > '9' || digit < '0' || num > 0x7fffffff || num < 0x80000000){
            	isValid = false;
                return 0;
            }
            num = num * 10 + (digit - '0');
        }
        if(isFu){
            return -num;
        }
        return num;
    }

}
