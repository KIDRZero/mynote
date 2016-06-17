package com.liuyong666.offer;

import java.util.Stack;

public class Offer07 {
	/**
	 * 用两个栈实现队列
	 * 题目描述：
	 * 		用两个栈来实现一个队列，完成队列的Push和Pop操作。
	 * 		 队列中的元素为int类型。
	 * 思路：
	 * 		栈A负责入栈，栈B负责出栈
	 * 		入栈进入栈A即可，出栈需判断
	 * 		若栈B不为空，直接弹出栈顶元素
	 * 		若栈B为空，将栈A中所有元素弹入栈B中，然后弹出栈B栈顶元素
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
