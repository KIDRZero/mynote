package com.liuyong666.util;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class MyLinkedList {
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 输入一个链表，输出该链表中倒数第k个结点。
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head,int k) {

        if(head == null || k <= 0){
            return null;
        }
        
        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }
        if(k > len){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        while(fast != null){
            if(index > k - 1){
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }
        
        return slow;
        
    }
	
	/**
	 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
	 * 给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
	 * @param pNode
	 * @return
	 */
	public boolean removeNode(ListNode pNode) {
        if(pNode == null || pNode.next == null){
            return false;
        }
        int temp = pNode.val;
        pNode.val = pNode.next.val;
        pNode.next.val = pNode.val;
        pNode.next = null;
        return true;
    }

}
