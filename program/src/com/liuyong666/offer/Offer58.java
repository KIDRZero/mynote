package com.liuyong666.offer;

public class Offer58 {
	/*
	 * ����������һ�����
	 * ��Ŀ����
	 * 		����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
	 * 		ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
	 */
	class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        TreeLinkNode node = pNode.right;
        //��ǰ������Һ���
        if(node != null){
            while(node != null && node.left != null){
                node = node.left;
            }
            return node;
        }else{
            //��ǰ������Һ��ӣ������Ǹ���������
            if(pNode != null && pNode.next != null && pNode == pNode.next.left){
                return pNode.next;
            }else{
                //��ǰ������Һ��ӣ������Ǹ������Һ��ӡ������Ҹ���㣬ֱ����������丸���ĸ���������
                node = pNode;
                while(node != null && node.next != null && node == node.next.right){
                    node = node.next;
                }
                return node.next;
            }
            
        }
        
        
    }

}
