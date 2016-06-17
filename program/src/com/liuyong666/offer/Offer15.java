package com.liuyong666.offer;

public class Offer15 {
	
	public static class ListNode{
		int value;
		ListNode next = null;
		public ListNode(int value){
			this.value = value;
		}
	}
	
	/*
	 * 
	 * 链表中倒数第k个结点
	 */
	//遍历两次，第一次确定链表长度，第二次返回第n-k+1个结点，即为所求
	//注意k不能超过链表长度，代码中要进行判断
	public static ListNode findKthToTail(ListNode head,int k){
		if(head == null || k <= 0 ){
			return null;
		}
		
		ListNode node = head;
		int nodesNum = 1;
		while(node.next != null){
			nodesNum++;
			node = node.next;
		}
		
		node = head;
		int count = 1;
		while(k <= nodesNum && count != nodesNum - k + 1){
			count++;
			node = node.next;
		}
		if(k <= nodesNum){
			return node;
		}
		return null;
	}
	/*
	 * 高效解法
	 * 前后指针，前指针先走k-1个结点，从第k个结点开始，后指针也跟着走。
	 * 当前指针的next为null时，此时后指针所在的位置就为链表的第k个结点
	 * 同样注意还没走到第k个结点链表就结束的情况
	 */
	public static ListNode findKthToTail2(ListNode head,int k){
		if(head == null || k <= 0)
			return null;
		ListNode pre = head;
		ListNode behind = null;
		for(int i = 0; i < k - 1; i++){
			if(pre.next != null){
				pre = pre.next;
			}else{
				return null;
			}
		}
		
		behind = head;
		while(pre.next != null){
			pre = pre.next;
			behind = behind.next;
		}
		return behind;
	}

}
