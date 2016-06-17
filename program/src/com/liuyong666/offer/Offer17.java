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
	 * ��Ŀ����
	 * ���������������������������������ϳɺ������
	 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
	 */
	
	/*
	 * �ݹ�ⷨ
	 * �Ƚ���������Ŀ�ͷ��㣬�����ȷ���ϲ�������ĵ�һ�����
	 * ���ϲ���Ľ���⣬�ٴαȽ���������Ŀ�ͷ��㣬�����ȷ���ϲ�������ĵڶ������
	 * �Դ����ƣ�ֱ�����н�����Ϊ�ϲ��������еĽ��
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
     * �ǵݹ�ⷨ
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
    	
    	//��ʼ����һ�����
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
    	
    	//������������ȡ����С�Ľ�㣬���뵽�ϲ�������
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
    	
    	//����ʣ��Ľ��
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
