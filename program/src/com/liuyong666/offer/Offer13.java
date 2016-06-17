package com.liuyong666.offer;

public class Offer13 {
	/*
	 * ��O(1)ʱ��ɾ��������
	 * ��Ŀ������
	 * 		�������������ͷָ���һ�����ָ�룬����һ��������O(1)ʱ��ɾ���ý�㡣
	 * 		�����㶨�����£�
	 */
	
	 public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
	 }
	 
	 public void deleteNode(ListNode head, ListNode targetNode){
		 if(head == null || targetNode == null){
			 return;
		 }
		 
		 //Ҫɾ���Ľ�㲻��β���
		 if(targetNode.next != null){
			 targetNode.val = targetNode.next.val;
			 targetNode.next = targetNode.next.next;
		 }
		 //����ֻ��һ����㣬ɾ��ͷ���(Ҳ��β���)
		 else if(head == targetNode){
			 head = null;
		 }
		 //�������ж����㣬ɾ��β���
		 else{
			 ListNode curNode = head;
			 while(curNode.next != targetNode){
				 curNode = curNode.next;
			 }
			 curNode.next = null;
		 }
		 
	 }

}
