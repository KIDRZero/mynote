package com.liuyong666.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer56 {
	/*
	 * 题目描述
	 * 		一个链表中包含环，请找出该链表的环的入口结点。
	 */
	static class ListNode {
	    int val;
	    ListNode next = null;

	    
	    
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	//相遇点到入口点的距离等于链表开头到入口点的距离
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null){
			slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
	
	//入口结点是链表中第一个重复的结点，对应HashSet中第一次插入失败的结点
	public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        Set<ListNode> set = new HashSet<>();
        while(pHead != null && set.add(pHead)){
            pHead = pHead.next;
        }
        return pHead;
        
    }

}
