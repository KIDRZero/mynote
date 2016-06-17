package com.liuyong666.offer;

public class Offer37 {
	/*
	 * ��������ĵ�һ���������
	 * ��Ŀ����
	 * 		�������������ҳ����ǵĵ�һ��������㡣
	 */
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null){
            return null;
        }
         // �õ���������ĳ���
        int len1 = 0;
        int len2 = 0;
        
        ListNode temp = pHead1;
        while (temp != null) {
            len1++;
            temp = temp.next;
        }
        temp = pHead2;
        while (temp != null) {
            len2++;
            temp = temp.next;
        }

        // ���������������Ľ�����
        int nodeDif = len1 - len2;
        ListNode pListNodeLong = pHead1;
        ListNode pListNodeShort = pHead2;
        if (nodeDif < 0) {
            pListNodeLong = pHead2;
            pListNodeShort = pHead1;
            nodeDif = len2 - len1;
        }
        
        // �ýϳ����Ǹ��������߼���
        for (int i = 0; i < nodeDif; i++) 
            pListNodeLong = pListNodeLong.next;
        // ��ʼѰ��
        while (pListNodeLong != null && pListNodeShort != null
                && pListNodeLong != pListNodeShort) {
            pListNodeLong = pListNodeLong.next;
            pListNodeShort = pListNodeShort.next;
        }
        
        //�õ���������ĵ�һ���������
        ListNode pFirstCommonListNode = pListNodeLong;
        return pFirstCommonListNode;
         
    }
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(6);
		head1.next.next.next.next = new ListNode(7);
		ListNode head2 = new ListNode(4);
		head2.next = new ListNode(5);
		head2.next.next = head1.next.next.next;
		head2.next.next.next = head1.next.next.next.next;
		System.out.println(new Offer37().findFirstCommonNode(head1, head2).val);
	}

}
