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
	 * ����һ����������������е�����k����㡣
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
	 * ʵ��һ���㷨��ɾ�����������м��ĳ����㣬�ٶ���ֻ�ܷ��ʸý�㡣
	 * ������ɾ���Ľڵ㣬��ִ��ɾ�����������ýڵ�Ϊβ�ڵ㣬����false�����򷵻�true
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
