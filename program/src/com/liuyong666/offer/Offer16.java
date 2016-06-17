package com.liuyong666.offer;

import com.liuyong666.offer.Offer15.ListNode;

public class Offer16 {
	class ListNode{
		int value;
		ListNode next = null;
		public ListNode(int value){
			this.value = value;
		}
	}
	/*
	 * ����һ�������ͷ��㣬��ת�����������ת���ͷ���
	 * 
	 * ����������
	 * �����һ����㣬�Է�ֹ��ǰ����nextֵ���º�����Ͽ�
	 * ����ǰһ����㣬�Ա㵱ǰ����nextֵ����Ϊǰһ�����
	 * ���һ����㽫�Ƿ�ת֮���ͷ��㣬����ý�㷵��
	 * 
	 */
    public static ListNode reverseList(ListNode head) {
    	
    	ListNode reverseListHead = null;
    	ListNode curNode = head;
    	ListNode preNode = null;
    	ListNode nextNode = null;
    	
    	while(curNode != null){
    		nextNode = curNode.next;
    		if(nextNode == null){
    			reverseListHead = curNode;
    		}
    		
    		curNode.next = preNode;
    		preNode = curNode;
    		curNode = nextNode;
    		
    	}
    	
    	return reverseListHead;
    }

}
