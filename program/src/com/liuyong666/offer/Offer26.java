package com.liuyong666.offer;

public class Offer26 {
	/*
	 * ��������ĸ���
	 * ��Ŀ����
	 * 		����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩������һ����������
	 */
	
	class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;
		
		public RandomListNode(int label){
			this.label = label;
		}
	}
	
	/*
	 * ˼·��
	 * 		��������ÿ������߸�����ͬ�Ľ�㣬����nextָ��
	 * 		��������ָ��
	 * 		ȡż����㴮������������Ϊ���ƺ������
	 */
    public RandomListNode clone(RandomListNode pHead)
    {
    	cloneNodes(pHead);
    	connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

	//����ԭʼ�����������N�������½��N`���ٰ�N`���ӵ�N�ĺ���
	private void cloneNodes(RandomListNode pHead) {
		RandomListNode curNode = pHead;
		while(curNode != null){
			RandomListNode nextNode = curNode.next;
			RandomListNode copyNode = new RandomListNode(curNode.label);
			copyNode.next = nextNode;
			copyNode.random = null;
			
			curNode.next = copyNode;
			curNode = copyNode.next;
		}
		
	}
	
	//���ԭʼ�����ϵĽ��N��randomָ��S��������Ӧ�ĸ��ƽ��N`��randomָ��S����һ�����S`
	private void connectRandomNodes(RandomListNode pHead) {
		RandomListNode curNode = pHead;
		while(curNode != null){
			RandomListNode copyNode = curNode.next;
			if(curNode.random != null){
				copyNode.random = curNode.random.next;
			}
			curNode = copyNode.next;
		}
		
	}
	
    //��ϸ��ƵĽ��
	private RandomListNode reconnectNodes(RandomListNode pHead) {
		
		RandomListNode curNode = pHead;
		RandomListNode copyHead = null;
		RandomListNode copyNode = null;
		
		//����ͷ���
		if(curNode != null){
			copyHead = curNode.next;
			copyNode = curNode.next;
			curNode.next = copyNode.next;
			curNode = curNode.next;
			
		}
		
		while(curNode != null){
			 copyNode.next = curNode.next;
			 copyNode = copyNode.next;
			 curNode.next = copyNode.next;
			 curNode = curNode.next;
				
		}
		return copyHead;
	}

}
