package com.liuyong666.offer;

import java.util.Stack;

public class Offer19 {
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	/*
	 * 请完成一个函数，输入一个二叉树，输出它的镜像
	 * 输入描述:
二叉树的镜像定义：源二叉树 
    	      8
    	    /   \
    	   6    10
    	  / \   / \
    	 5   7 9  11
    	镜像二叉树
    	      8
    	    /   \
    	   10    6
    	  / \   / \
    	 11  9 7   5
     *
     *思路：
     *先序遍历给定树的每个结点
     *若遍历到的结点有子结点，就交换它的两个子结点
     *当交换完所有非叶子节点的左右子节点之后，就得到了树的镜像
	 */
	//递归实现
    public void mirror(TreeNode root) {
    	if(root == null || (root.left == null && root.right == null)){
    		return ;
    	}
    	
    	
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    	if(root.left != null){
    		mirror(root.left);
    	}
    	
    	if(root.right != null){
    		mirror(root.right);
    	}
    }
    
    //非递归实现
    public void mirror2(TreeNode root) {
    	if(root == null || (root.left == null && root.right == null)){
    		return ;
    	}
    	
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	while(!s.isEmpty()){
    		TreeNode node = s.pop();
    		
    		//交换左右孩子结点
    		TreeNode nodeTemp = node.left;
    		node.left = node.right;
    		node.right = nodeTemp;
    		
    		//遍历左子树
    		if(node.left != null){
    			s.push(node.left);
    		}
    		
    		//遍历右子树
    		if(node.right != null){
    			s.push(node.right);
    		}
    		
    	}
    }

}
