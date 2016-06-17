package com.liuyong666.offer;

public class Offer26 {
	/*
	 * 复杂链表的复制
	 * 题目描述
	 * 		输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。复制一个复杂链表
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
	 * 思路：
	 * 		遍历链表，每个结点后边复制相同的结点，设置next指针
	 * 		复制特殊指针
	 * 		取偶数结点串联成新链表，即为复制后的链表
	 */
    public RandomListNode clone(RandomListNode pHead)
    {
    	cloneNodes(pHead);
    	connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

	//复制原始链表的任意结点N并创建新结点N`，再把N`链接到N的后面
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
	
	//如果原始链表上的结点N的random指向S，则它对应的复制结点N`的random指向S的下一个结点S`
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
	
    //组合复制的结点
	private RandomListNode reconnectNodes(RandomListNode pHead) {
		
		RandomListNode curNode = pHead;
		RandomListNode copyHead = null;
		RandomListNode copyNode = null;
		
		//设置头结点
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
