package com.liuyong666.offer;

import java.util.Stack;

public class Offer21 {
	/*
	 * ����min������ջ
	 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
	 * ������
	 * ������ջ�Ļ�����ά��һ�����������Сֵ�ĸ���ջ
	 * ÿ����ջ������ջ��Ԫ�ض�Ҫ�͸���ջջ��Ԫ�رȽϣ��������ջ��Ԫ�ظ�С��������Ҳ������Сջ�У�������Сջ�ٴ�ѹ����ջ��Ԫ��
	 * ÿ�γ�ջ������ջ�͸���ջͬʱ����Ԫ��
	 * �����Ϳ��Ա�֤���κ�����£�����ջջ��Ԫ��ʼ��������ջ�е���СԪ��
	 */
    public class MinFunctionStack{
    	
    	Stack<Integer> data = new Stack<Integer>();
    	Stack<Integer> assist = new Stack<Integer>();
    	
    	public void push(int node) {
            data.push(node);
            if(assist.size() == 0 || node < assist.peek()){
            	assist.push(node);
            }else{
            	assist.push(assist.peek());
            }
        }
        
        public void pop() {
        	if(data.size() > 0 && assist.size() > 0){
        		data.pop();
        		assist.pop();
        	}
        }
        
        public int top() {
        	if(data.size() > 0){
        		return data.peek();
        	}
        	return Integer.MIN_VALUE;
            
        }
        
        public int min() {
        	if(data.size() > 0 && assist.size() > 0){
        		return assist.peek();
        	}
        	return Integer.MIN_VALUE;
        }
    	
    }

}
