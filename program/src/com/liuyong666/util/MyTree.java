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
	  * ��ȫ�����������
	  * 		����һ����ȫ��������ͷ�ڵ�head������������Ľڵ������
	  * 		�����ȫ�������Ľڵ���ΪN����ʵ��ʱ�临�Ӷȵ���O(N)�Ľⷨ�� 
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
		
		//ǰ������ݹ�ʵ��
		public void preOrderTraverse(TreeNode root){
			if(root == null){
				return;
			}
			System.out.println(root.val);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
			
		}
		//ǰ������ǵݹ�ʵ��
		public void preOrderTraverse1(TreeNode root){
			Stack<TreeNode> stack = new Stack<>();
			while(root != null || !stack.isEmpty()){
				//����������
				while(root != null){
					System.out.println(root.val);
					stack.push(root);
					root = root.left;
				}
				//����������
				if(!stack.empty()){
					root = stack.pop();
					root = root.right;
				}
			}
			
		}	
		
		//��������ݹ�ʵ��
		public void inOrderTraverse(TreeNode root){
			if(root == null){
				return;
			}
			inOrderTraverse(root.left);
			System.out.println(root.val);
			inOrderTraverse(root.right);
		}

		//��������ǵݹ�ʵ��
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
		
		//��������ݹ�ʵ��
		public void postOrderTraverse(TreeNode root){
			if(root == null){
				return;
			}
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			System.out.println(root.val);
		}
		
		//��������ǵݹ�ʵ��
		/*
		 * ��������ķǵݹ�ʵ����ǰ�����ַ�ʽ��ͬ�����ڸ�����������ʵģ�
		 * �ڷ��ʵ�ʱ�򴴽�һ��ջ��������Ľ����������������Ҫʹ��һ������ջ����סÿ�����ʽ���˫�׽��
		 */
		public void postOrderTraverse1(TreeNode root){
			Stack<TreeNode> s1 = new Stack<>();
			//s2��סÿ�����ʵ�
			Stack<Integer> s2 = new Stack<>();
			//���ջs2��ջ����1����ʶ��ǰ���ʵĽ��
			Integer i = new Integer(1);
			while(root != null || !s1.isEmpty()){
				while(root != null){
					s1.push(root);
					s2.push(0);
					root = root.left;
				}
				//���ѭ����Ŀ���Ƕ�ջs2ջ��Ϊ1ʱ��Ӧ��ջs1��ջ��Ԫ�ؽ��з���
				while(!s1.isEmpty() && s2.peek().equals(i)){
					s2.pop();
					System.out.println(s1.pop().val);
				}
				//������������ͷ�󣬾Ϳ��Է������Һ�����
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
