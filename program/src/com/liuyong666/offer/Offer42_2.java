package com.liuyong666.offer;

public class Offer42_2 {
	/*
	 * ����ת�ַ���
	 * 
	 * ��Ŀ������
	 * 		�ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
	 * 		�붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
	 * 		���������ַ�����abcdefg��������2���ú�����������ת2λ�õ��Ľ����cdefgab����
	 */
	//ʹ��Java�и�ƴ�����Ĵ���
	public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0){
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        return str2 + str1;
    }
	

	//ԭ�ز����ַ����ķ���
	public String LeftRotateString1(String str,int n) {
        if(str == null || str.length() == 0 || n < 0){
            return "";
        }
        char[] chs = str.toCharArray();
        int len = chs.length;
        swap(chs, 0, n - 1);
        swap(chs, n, len - 1);
        swap(chs, 0, len - 1);
        return new String(chs);
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
