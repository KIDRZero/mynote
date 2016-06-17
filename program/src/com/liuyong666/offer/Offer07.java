package com.liuyong666.offer;

import java.util.Stack;

public class Offer07 {
	/**
	 * ������ջʵ�ֶ���
	 * ��Ŀ������
	 * 		������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������
	 * 		 �����е�Ԫ��Ϊint���͡�
	 * ˼·��
	 * 		ջA������ջ��ջB�����ջ
	 * 		��ջ����ջA���ɣ���ջ���ж�
	 * 		��ջB��Ϊ�գ�ֱ�ӵ���ջ��Ԫ��
	 * 		��ջBΪ�գ���ջA������Ԫ�ص���ջB�У�Ȼ�󵯳�ջBջ��Ԫ��
	 */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
}
