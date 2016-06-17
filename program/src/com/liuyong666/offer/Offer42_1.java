package com.liuyong666.offer;

public class Offer42_1 {
	/*
	 * ��ת����˳��
	 * 
	 * ��Ŀ������
	 * 		����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
	 * 		Ϊ���ڼ䣬�����ź���ͨ��ĸһ������
	 */
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        char[] cArr = str.toCharArray();
        int len = cArr.length;
        swap(cArr, 0, len - 1);
        int letterHead = 0;
        int letterTail = len - 1;
        for(int i = 1; i < len; i++){
            if(cArr[i - 1] == ' ' && cArr[i] != ' ' ){
                letterHead = i;
                continue;
            }
            if(cArr[i - 1] != ' ' && cArr[i] == ' '){
                letterTail = i - 1;
                swap(cArr, letterHead, letterTail);
            }
        }
        if(cArr[len - 1] != ' '){
            swap(cArr, letterHead, len - 1);
        }
        return new String(cArr);
        
    }
    private void swap(char[] a, int start, int end){
        while(start < end){
            char tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

}
