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
	 * 输入一个链表的头结点，反转该链表并输出翻转后的头结点
	 * 
	 * 遍历该链表
	 * 保存后一个结点，以防止当前结点的next值更新后链表断开
	 * 保存前一个结点，以便当前结点的next值更新为前一个结点
	 * 最后一个结点将是反转之后的头结点，保存该结点返回
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
