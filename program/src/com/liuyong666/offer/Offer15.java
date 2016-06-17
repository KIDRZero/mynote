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
	 * �����е�����k�����
	 */
	//�������Σ���һ��ȷ�������ȣ��ڶ��η��ص�n-k+1����㣬��Ϊ����
	//ע��k���ܳ��������ȣ�������Ҫ�����ж�
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
	 * ��Ч�ⷨ
	 * ǰ��ָ�룬ǰָ������k-1����㣬�ӵ�k����㿪ʼ����ָ��Ҳ�����ߡ�
	 * ��ǰָ���nextΪnullʱ����ʱ��ָ�����ڵ�λ�þ�Ϊ����ĵ�k�����
	 * ͬ��ע�⻹û�ߵ���k���������ͽ��������
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
