package com.liuyong666.offer;

import com.liuyong666.offer.Offer56.ListNode;

public class Offer57 {
	/*
	 * 删除链表中重复的结点
	 * 题目描述
	 * 		在一个排序的链表中，存在重复的结点，
	 * 		请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
	 * 		例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
	 */
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode deleteDuplication(ListNode pHead)
    {

        if(pHead == null){
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode pre = first;
        ListNode cur = pHead;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;  
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
        
    }

}
