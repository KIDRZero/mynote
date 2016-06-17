package com.liuyong666.offer;

public class Offer13 {
	/*
	 * 在O(1)时间删除链表结点
	 * 题目描述：
	 * 		给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
	 * 		链表结点定义如下：
	 */
	
	 public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
	 }
	 
	 public void deleteNode(ListNode head, ListNode targetNode){
		 if(head == null || targetNode == null){
			 return;
		 }
		 
		 //要删除的结点不是尾结点
		 if(targetNode.next != null){
			 targetNode.val = targetNode.next.val;
			 targetNode.next = targetNode.next.next;
		 }
		 //链表只有一个结点，删除头结点(也是尾结点)
		 else if(head == targetNode){
			 head = null;
		 }
		 //链表中有多个结点，删除尾结点
		 else{
			 ListNode curNode = head;
			 while(curNode.next != targetNode){
				 curNode = curNode.next;
			 }
			 curNode.next = null;
		 }
		 
	 }

}
