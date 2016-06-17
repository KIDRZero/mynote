package com.liuyong666.offer;


public class Offer17 {
	
	
	
	public static class ListNode{
		int value;
		ListNode next = null;
		public ListNode(int value){
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode a = list1.next = new ListNode(3);
		ListNode b = a.next = new ListNode(5);
		
		ListNode list2 = new ListNode(2);
		ListNode c = list2.next = new ListNode(4);
		ListNode d = c.next = new ListNode(6);
		ListNode p = list1;
		while(p != null){
			System.out.print(p.value+" ");
			p = p.next;
		}
		System.out.println();
		
		p = list2;
		while(p != null){
			System.out.print(p.value+" ");
			p = p.next;
		}
		System.out.println();
		
		p = merge2(list1, list2);
		while(p != null){
			System.out.print(p.value+" ");
			p = p.next;
		}
		
		
	}
	
	/*
	 * 题目描述
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，
	 * 当然我们需要合成后的链表满足单调不减规则。
	 */
	
	/*
	 * 递归解法
	 * 比较两个链表的开头结点，则可以确定合并后链表的第一个结点
	 * 除合并后的结点外，再次比较两个链表的开头结点，则可以确定合并后链表的第二个结点
	 * 以此类推，直到所有结点均成为合并后链表中的结点
	 */
    public static ListNode merge(ListNode list1,ListNode list2) {
    	
    	if(list1 == null){
    		return list2;
    	}
    	if(list2 == null){
    		return list1;
    	}
    	
    	ListNode mergeListHead = null;
    	if(list1.value < list2.value){
    		mergeListHead = list1;
    		mergeListHead.next =merge(list1.next,list2);
    	}else{
    		mergeListHead = list2;
    		mergeListHead.next = merge(list1,list2.next);
    	}
    	
        return mergeListHead;
    }
    
    /*
     * 非递归解法
     */
    public static ListNode merge2(ListNode list1,ListNode list2) {
    	
    	if(list1 == null){
    		return list2;
    	}
    	if(list2 == null){
    		return list1;
    	}
    	
    	ListNode mergeList = null;
    	ListNode curNode = null;
    	
    	//初始化第一个结点
    	if(list1.value < list2.value){
    		curNode = list1;
    		list1 = list1.next;
    		curNode.next = null;
    		mergeList = curNode;
    	}else{
    		curNode = list2;
    		list2 = list2.next;
    		curNode.next = null;
    		mergeList = curNode;
    	}
    	
    	//遍历两个链表，取出较小的结点，加入到合并链表中
    	ListNode mergeNode = mergeList;
    	while(list1 != null && list2 != null){
    		if(list1.value < list2.value){
    			curNode = list1;
    			list1 = list1.next;
    			curNode.next = null;
    			mergeNode.next = curNode;
    			mergeNode = mergeNode.next;
    		}else{
    			curNode = list2;
    			list2 = list2.next;
    			curNode.next = null;
    			mergeNode.next = curNode;
    			mergeNode = mergeNode.next;
    		}
    	}
    	
    	//处理剩余的结点
    	while(list1 != null){
    		curNode = list1;
    		list1 = list1.next;
    		curNode.next = null;
    		mergeNode.next = curNode;
    		mergeNode = mergeNode.next;
    	}
    	while(list2 != null){
    		curNode = list2;
    		list2 = list2.next;
    		curNode.next = null;
    		mergeNode.next = curNode;
    		mergeNode = mergeNode.next;
    	}
    	
    	return mergeList;
    }

}
