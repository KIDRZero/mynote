package com.liuyong666.util;

import java.util.Stack;

public class MyTree {
	 static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	 }
	 
	 /*
	  * 完全二叉树结点数
	  * 		给定一棵完全二叉树的头节点head，返回这棵树的节点个数。
	  * 		如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。 
	  */
	    public int nodeNum(TreeNode head) {
	    	if(head == null){
	    		return 0;
	    	}
	    	return bs(head, 1, mostLeftLevel(head, 1));
	    }

		private int bs(TreeNode node, int l, int h) {

			if(l == h){
				return 1;
			}
			if(mostLeftLevel(node.right, l + 1) == h){
				return (1 << (h - l)) + bs(node.right, l + 1, h);
			}else{
				return (1 << (h - l - 1)) + bs(node.left,  l + 1, h);
			}
		}

		private int mostLeftLevel(TreeNode node, int level) {
			while(node != null){
				level++;
				node = node.left;
			}
			return level - 1;
		}	 
		
		//前序遍历递归实现
		public void preOrderTraverse(TreeNode root){
			if(root == null){
				return;
			}
			System.out.println(root.val);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
			
		}
		//前序遍历非递归实现
		public void preOrderTraverse1(TreeNode root){
			Stack<TreeNode> stack = new Stack<>();
			while(root != null || !stack.isEmpty()){
				//遍历左子树
				while(root != null){
					System.out.println(root.val);
					stack.push(root);
					root = root.left;
				}
				//遍历右子树
				if(!stack.empty()){
					root = stack.pop();
					root = root.right;
				}
			}
			
		}	
		
		//中序遍历递归实现
		public void inOrderTraverse(TreeNode root){
			if(root == null){
				return;
			}
			inOrderTraverse(root.left);
			System.out.println(root.val);
			inOrderTraverse(root.right);
		}

		//中序遍历非递归实现
		public void inOrderTraverse1(TreeNode root){
			Stack<TreeNode> stack = new Stack<>();
			while(root != null || !stack.isEmpty()){
				while(root != null){
					stack.push(root);
					root = root.left;
				}
				if(!stack.isEmpty()){
					root = stack.pop();
					System.out.println(root.val);
					root = root.right;
				}
			}
		}
		
		//后序遍历递归实现
		public void postOrderTraverse(TreeNode root){
			if(root == null){
				return;
			}
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			System.out.println(root.val);
		}
		
		//后序遍历非递归实现
		/*
		 * 后序遍历的非递归实现与前面两种方式不同，由于根结点是最后访问的，
		 * 在访问的时候创建一个栈保存遍历的结果还不够，所以需要使用一个辅助栈来记住每个访问结点的双亲结点
		 */
		public void postOrderTraverse1(TreeNode root){
			Stack<TreeNode> s1 = new Stack<>();
			//s2记住每个访问的
			Stack<Integer> s2 = new Stack<>();
			//如果栈s2的栈顶是1，标识当前访问的结点
			Integer i = new Integer(1);
			while(root != null || !s1.isEmpty()){
				while(root != null){
					s1.push(root);
					s2.push(0);
					root = root.left;
				}
				//这个循环的目的是对栈s2栈顶为1时对应的栈s1的栈顶元素进行访问
				while(!s1.isEmpty() && s2.peek().equals(i)){
					s2.pop();
					System.out.println(s1.pop().val);
				}
				//访问左子树到头后，就可以访问其右孩子了
				if(!s1.isEmpty()){
					s2.pop();
					s2.push(i);
					root = s1.peek();
					root = root.right;
				}
			}
		}
		
		
		public static void main(String[] args) {
		        TreeNode root = new TreeNode(8);
		        TreeNode node1 = new TreeNode(6);
		        TreeNode node2 = new TreeNode(10);
		        TreeNode node3 = new TreeNode(5);
		        TreeNode node4 = new TreeNode(7);
		        TreeNode node5 = new TreeNode(9);
		        TreeNode node6 = new TreeNode(11);
		        TreeNode node7 = new TreeNode(15);
		        TreeNode node8 = new TreeNode(24);
		        TreeNode node9 = new TreeNode(30);
		        TreeNode node10 = new TreeNode(28);

		        root.left = node1;
		        root.right = node2;
		        node1.left = node3;
		        node3.left = node7;
		        node7.right = node8;
		        node1.right = node4;
		        node2.left = node5;
		        node2.right = node6;
		        node5.left = node9;
		        node6.right = node10;
		        
		        new MyTree().postOrderTraverse1(root);
		    }

		
}
