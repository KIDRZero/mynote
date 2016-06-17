package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.Collections;

public class Offer05 {
	/**
	 * 从尾到头打印链表
	 * 题目描述：
	 * 		输入一个链表，从尾到头打印链表每个节点的值。 
	 */
	 public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
	 }
	 
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

}
