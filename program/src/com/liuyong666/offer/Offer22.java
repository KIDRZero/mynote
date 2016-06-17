package com.liuyong666.offer;

import java.util.ArrayList;

public class Offer22 {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		boolean possible = false;
		//���ѹ��ջ�е�Ԫ��
		ArrayList<Integer> data = new ArrayList<Integer>();
		if(pushA.length > 0 && popA.length > 0 && pushA.length == popA.length){
			int len = pushA.length;
			//��һ������Ԫ��λ��
			int pop = 0;
			//��һ��Ҫ����Ԫ�ص�λ��
			int nextPop = 0;
			
			//��һ��ѹ��ջ�е�Ԫ��λ��
			int push = 0;
			//��һ��Ҫѹ��ջ�е�Ԫ��λ��
			int nextPush = 0;
			
			int index = -1;
			while(nextPop - pop < len){
				//���Ҫ������Ԫ����ջ��Ԫ�ز���ȣ���һֱѹջֱ�����
				while(data.size() == 0 || data.get(index) != popA[nextPop]){
					
					//��ȫ��Ԫ��������֮�󣬽���ѭ��
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
				
				//�Ƴ���һ���Ƚϵ�Ԫ��
				data.remove(index--);
				//�ж���һ��������Ԫ��
				nextPop++;
				
			}
			//�ڼ���ȫ��Ԫ�رȽ���ϲ��ҵ�������Ҳ�Ƚ����
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
