package com.liuyong666.offer;

public class Offer53 {
	/*
	 * ������ʽƥ��
	 * ��Ŀ������
	 * 		��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
	 * 		ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
	 * 		 �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
	 * 		���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
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
			//����ƥ�䵽ĩβ��ģʽ��Ҫô��ǰλ�õ��ַ���*�����򷵻�false
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
         * һ�����ģʽ������һ���ַ���*�� 1.1 ����ģʽ���ĵ�ǰ�ַ������������ַ�����ƥ�䣬����ܳ������������
         * 1��ģʽ���ĵ�ǰ�ַ�ƥ�䵽0���ַ������������䣬ģʽ���ƶ��������ַ�
         * 2��ģʽ���ĵ�ǰ�ַ�ƥ�䵽1���ַ����������ƶ�һ��λ�ã�ģʽ���ƶ�����λ��
         * 3��ģʽ���ĵ�ǰ�ַ�ƥ�䵽����ַ����������ƶ�һ��λ�ã�ģʽ���ƶ�����λ�á� 1.2 �������ƥ��Ļ�: �������䣬ģʽ���ƶ�����λ�ã�
         * ���������һ���ַ�����*�����������ַ�����ƥ�� �������ģʽ������һ���ַ���.����ͽ���һ���ַ���ƥ��
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
