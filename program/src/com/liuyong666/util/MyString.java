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
			throw new RuntimeException("�������");
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
	 * �ַ�������
	 * ����һ���������ַ�����������Ҫ������(Ҳ����O(n))��ʱ���������һЩ���Ρ�
	 * ��������ַ����а�����һЩ�ո񣬾���"Hello World"һ����Ȼ������Ҫ�����ǰ��Ÿ��ַ������ɿո�����ĵ��ʷ���ͬʱ��תÿ���ַ��Ĵ�Сд��
	 * ����"Hello World"���κ�ͱ����"wORLD hELLO"��
	 * ��������:
	 * 		����һ���ַ���s�Լ����ĳ���n(1��n��500)
	 * �������:
	 * 		�뷵�ر��κ���ַ�������Ŀ��֤�������ַ������ɴ�Сд��ĸ�Ϳո񹹳ɡ�
	 * ��������:
	 * 		"This is a sample",16
	 * �������:
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
	 * ȷ���ַ�����
	 * 
	 * ��ʵ��һ���㷨��ȷ��һ���ַ����������ַ��Ƿ�ȫ����ͬ��
	 * ��������Ҫ������ʹ�ö���Ĵ洢�ṹ��
	 * ����һ��string iniString���뷵��һ��boolֵ,
	 * True���������ַ�ȫ����ͬ��False���������ͬ���ַ���
	 * ��֤�ַ����е��ַ�ΪASCII�ַ����ַ����ĳ���С�ڵ���3000��
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
     * ԭ����ת
     * 
     * ��ʵ��һ���㷨���ڲ�ʹ�ö������ݽṹ�ʹ���ռ������£���תһ���������ַ���(����ʹ�õ������̱���)��
     * ����һ��string iniString���뷵��һ��string��Ϊ��ת����ַ�����
     * ��֤�ַ����ĳ���С�ڵ���5000��
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
     * ȷ����������ͬ��
     * ���������ַ��������д����ȷ������һ���ַ������ַ��������к��ܷ�����һ���ַ�����
     * ����涨��СдΪ��ͬ�ַ����ҿ����ַ����ص�ո�
     * ����һ��string stringA��һ��string stringB���뷵��һ��bool�����������Ƿ��������к����ͬ��
     * ��֤�����ĳ��ȶ�С�ڵ���5000��
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
	 * �ո��滻
	 * ���дһ�����������ַ����еĿո�ȫ���滻Ϊ��%20�����ٶ����ַ������㹻�Ŀռ����������ַ�������֪���ַ�������ʵ����(С�ڵ���1000)��ͬʱ��֤�ַ����ɴ�Сд��Ӣ����ĸ��ɡ�
����һ��string iniString Ϊԭʼ�Ĵ����Լ����ĳ��� int len, �����滻���string��
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
	 * �����ַ���ѹ��
	 * 
	 * �����ַ��ظ����ֵĴ�������дһ��������ʵ�ֻ������ַ���ѹ�����ܡ�
	 * ���磬�ַ�����aabcccccaaa����ѹ�����ɡ�a2b1c5a3������ѹ������ַ���û�б�̣��򷵻�ԭ�ȵ��ַ�����
	 * ����һ��string iniStringΪ��ѹ���Ĵ�(����С�ڵ���3000)����֤�����ַ����ɴ�СдӢ����ĸ��ɣ�����һ��string��Ϊ�����ѹ�����δ�仯�Ĵ���
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
	 * ��ת�Ӵ�
	 * �ٶ����Ƕ�֪���ǳ���Ч���㷨�����һ�������Ƿ�Ϊ�����ַ������Ӵ���
	 * �뽫����㷨��д��һ�����������������ַ���s1��s2�����д������s2�Ƿ�Ϊs1��ת���ɣ�Ҫ��ֻ�ܵ���һ�μ���Ӵ��ĺ�����
	 * ���������ַ���s1,s2,�뷵��boolֵ����s2�Ƿ���s1��ת���ɡ��ַ������ַ�ΪӢ����ĸ�Ϳո����ִ�Сд���ַ�������С�ڵ���1000��
	 */
	
	public boolean checkReverseEqual(String s1, String s2) {

		if(s1 == null || s2 == null || s1.length() != s2.length()){
			return false;
		}
		
		return (s1 + s1).contains(s2);
    }

}
