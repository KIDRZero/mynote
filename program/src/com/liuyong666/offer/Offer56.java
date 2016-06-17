package com.liuyong666.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer56 {
	/*
	 * ��Ŀ����
	 * 		һ�������а����������ҳ�������Ļ�����ڽ�㡣
	 */
	static class ListNode {
	    int val;
	    ListNode next = null;

	    
	    
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	//�����㵽��ڵ�ľ����������ͷ����ڵ�ľ���
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
	
	//��ڽ���������е�һ���ظ��Ľ�㣬��ӦHashSet�е�һ�β���ʧ�ܵĽ��
	public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        Set<ListNode> set = new HashSet<>();
        while(pHead != null && set.add(pHead)){
            pHead = pHead.next;
        }
        return pHead;
        
    }

}
