package com.liuyong666.offer;

import java.util.ArrayList;

public class Offer22 {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		boolean possible = false;
		//存放压入栈中的元素
		ArrayList<Integer> data = new ArrayList<Integer>();
		if(pushA.length > 0 && popA.length > 0 && pushA.length == popA.length){
			int len = pushA.length;
			//第一个弹出元素位置
			int pop = 0;
			//下一个要弹出元素的位置
			int nextPop = 0;
			
			//第一个压入栈中的元素位置
			int push = 0;
			//下一个要压入栈中的元素位置
			int nextPush = 0;
			
			int index = -1;
			while(nextPop - pop < len){
				//如果要弹出的元素与栈顶元素不相等，就一直压栈直到相等
				while(data.size() == 0 || data.get(index) != popA[nextPop]){
					
					//当全部元素添加完毕之后，结束循环
					if(nextPush - push == len){
						break;
					}
					
					data.add(pushA[nextPush]);
					nextPush++;
					index++;
					
				}
				if(data.get(index) != popA[nextPop]){
					break;
				}
				
				//移除第一个比较的元素
				data.remove(index--);
				//判断下一个待弹出元素
				nextPop++;
				
			}
			//在集合全部元素比较完毕并且弹出序列也比较完毕
			if(data.size() == 0 &&  nextPop - pop == len){
				possible = true;
			}
		}
		return possible;
	      
    }
	
	public static void main(String[] args) {
		int[] pushA = new int[]{1,2,3,4,5};
		int[] popA = new int[]{4,5,3,1,2};
		System.out.println(new Offer22().IsPopOrder(pushA, popA));
		
	}

}
