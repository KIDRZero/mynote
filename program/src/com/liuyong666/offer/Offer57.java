package com.liuyong666.offer;

import com.liuyong666.offer.Offer56.ListNode;

public class Offer57 {
	/*
	 * ɾ���������ظ��Ľ��
	 * ��Ŀ����
	 * 		��һ������������У������ظ��Ľ�㣬
	 * 		��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
	 * 		���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
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
