package com.liuyong666.offer;

import java.util.Stack;

public class Offer21 {
	/*
	 * 包含min函数的栈
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
	 * 解析：
	 * 在数据栈的基础上维护一个用来存放最小值的辅助栈
	 * 每次入栈，新入栈的元素都要和辅助栈栈顶元素比较，如果新入栈的元素更小，就让它也加入最小栈中，否则最小栈再次压入其栈顶元素
	 * 每次出栈，数据栈和辅助栈同时弹出元素
	 * 这样就可以保证在任何情况下，辅助栈栈顶元素始终是数据栈中的最小元素
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
