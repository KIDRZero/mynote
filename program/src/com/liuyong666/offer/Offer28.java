package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;

public class Offer28 {
	/*
	 * �ַ���������
	 * ��Ŀ����
	 * 		����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
	 * 		���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
	 * 		 ����밴��ĸ˳������� 
	 * ��������:
	 * 		����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
	 * ˼·��
	 * 		�Ȳ������Ƿ�����ض��ַ���Ҫ��һ���ַ�����ȫ���У����԰ѵ�һ���ַ��ͺ�����ַ�����������
	 * 		����һ���ַ�������ַ��ֿ��Կ��ɵ�һ���ַ��ͺ��������֣���һ���ݹ����
	 * 		ֻҪ��һ���ַ���λ��û�е����ַ�����ĩβ�ͷֱ𽫵�һ���ַ��������ַ����н���
	 * 
	 * ע�⣺
	 * 		��һ���ַ�������ĳ��λ�õ��ַ�������������Ҫ�ٴη�����������Ȼ˳��ͻᱻ����
	 * 		�ٸ����ӣ����ַ���abc�У��ڰѵ�һ���ַ�������a��������ַ�b��c��������һ�������ʱ��abc�����Ե�˳���ܸı�
	 * 		���Ե�a��b�����������bac֮����Ҫ�ٴν��������ַ������»ص�abc
	 * 
	 */
	
	public ArrayList<String> permutation(String str) {
		
		ArrayList<String> list = new ArrayList<String>();		
		
		if(str == null || str.length() == 0){
			return list;
		}
		
		list =  permutation(list, str.toCharArray(), 0, str.length());
		Collections.sort(list);
		return list;
    }

	//�ݹ�Ľ�����������ַ�����ӵ�list��
	private ArrayList<String> permutation(ArrayList<String> list, char[] str, int begin, int length) {
		
		if(begin == length - 1){
			if(!list.contains(String.valueOf(str))){
				list.add(String.valueOf(str));
			}
		}else{
			for(int i = begin; i < length; i++){
				if(i == begin || str[i] != str[begin]){
					swap(str, begin, i);
					permutation(list, str,begin + 1, length);
					swap(str, begin, i);
				}
			}
		}
		return list;
	}

	private void swap(char[] str, int begin, int i) {
		char temp = str[begin];
		str[begin] = str[i];
		str[i] = temp;
		
	}
	
	//�ǵݹ�ⷨ
	public ArrayList<String> permutation1(String str) {
		//ʹ��TreeSet������
		TreeSet<String> tree = new TreeSet<String>();
		//����һ��ջ����ÿ�����е��ַ����
		Stack<String[]> stack = new Stack<String[]>();
		//������յ����н��
		ArrayList<String> results = new ArrayList<String>();
		
		stack.push(new String[] {str,""});
		do{
			//����popStrs����str������ַ���
			String[] popStrs = stack.pop();
			//�մ�
			String oldStr = popStrs[1];
			//Str
			String stackStr = popStrs[0];
			for(int i = stackStr.length() - 1; i >= 0; i--){
				String[] strs = new String[]{
						stackStr.substring(0, i) + stackStr.substring(i + 1),
						oldStr + stackStr.substring(i, i + 1)
						};
				if(strs[0].length() == 0){
					tree.add(strs[1]);
				}else{
					stack.push(strs);
				}
				
			}
		}while(!stack.isEmpty());
		for(String s : tree){
			results.add(s);
		}
		
		return results;
		
		
	}
}
