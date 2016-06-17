package com.liuyong666.offer;

public class Offer58 {
	/*
	 * 二叉树的下一个结点
	 * 题目描述
	 * 		给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
	 * 		注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
        //当前结点有右孩子
        if(node != null){
            while(node != null && node.left != null){
                node = node.left;
            }
            return node;
        }else{
            //当前结点无右孩子，并且是父结点的左孩子
            if(pNode != null && pNode.next != null && pNode == pNode.next.left){
                return pNode.next;
            }else{
                //当前结点无右孩子，并且是父结点的右孩子。向上找父结点，直到父结点是其父结点的父结点的左孩子
                node = pNode;
                while(node != null && node.next != null && node == node.next.right){
                    node = node.next;
                }
                return node.next;
            }
            
        }
        
        
    }

}
