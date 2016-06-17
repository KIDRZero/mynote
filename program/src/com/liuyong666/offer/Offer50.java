package com.liuyong666.offer;

import java.util.Stack;

public class Offer50 {
	/*
	 * 最近公共祖先LCA问题
	 * 问题描述
	 * 		求有根树的任意两个节点的最近公共祖先。
	 */
	static class Node{
		int value;
		Node left;
		Node right;
		Node parent;
		public Node(int val){
			this.value = val;
		}
	}
	//二叉查找树
	/*
	 * 如果当前结点t 大于结点u、v，说明u、v都在t 的左侧，所以它们的共同祖先必定在t 的左子树中，故从t 的左子树中继续查找；
	 * 如果当前结点t 小于结点u、v，说明u、v都在t 的右侧，所以它们的共同祖先必定在t 的右子树中，故从t 的右子树中继续查找；
	 * 如果当前结点t 满足 u <t < v，说明u和v分居在t 的两侧，故当前结点t 即为最近公共祖先；
	 * 而如果u是v的祖先，那么返回u的父结点，同理，如果v是u的祖先，那么返回v的父结点。
	 */
	public Node query(Node root, Node u, Node v) {
		if(root == null || u == null || v == null){
			return null;
		}
		if(root== u || root==v){
			return root;
		}
		
		Node t = root;
		int left = u.value;
		int right = v.value;
		//二叉查找树内，如果左结点大于右结点，交换
		if(left > right){
			int temp = left;
			left = right;
			right = temp;
		}
		while (true) {    
	        //如果t小于u、v，往t的右子树中查找  
	        if (t.value < left) {    
	            t = t.right;    

	        //如果t大于u、v，往t的左子树中查找  
	        } else if (t.value > right) {    
	            t = t.left;    
	        } else {    
	            return t;    
	        }    
	    } 
	}
	
	/*
	 * 不是二叉查找树
	 * 
	 * 如果这棵树不是二叉查找树，只是一棵普通的二叉树呢？
	 * 如果每个结点都有一个指针指向它的父结点，于是我们可以从任何一个结点出发，得到一个到达树根结点的单向链表。因此这个问题转换为两个单向链表的第一个公共结点。
	 */
	public Node query1(Node root, Node u, Node v) {
		if(root == null || u == null || v == null){
			return null;
		}
		if(root== u || root==v){
			return root;
		}
		while(u.parent != null){
			u = u.parent;
			while(v.parent != null){
				v = v.parent;
				if(u == v){
					return u;
				}
			}
		}
		return null;
	}
	/*
	 * 如果没有指向父结点的指针
	 * 
	 * 先序解法，结点有重复遍历
	 * 如果给出根节点，LCA问题可以用递归很快解决。而关于树的问题一般都可以转换为递归（因为树本来就是递归描述），参考代码如下：
	 */

	public Node query3(Node root, Node u, Node v) {
		if(root == null || u == null || v == null){
			return null;
		}
		if(root== u || root==v){
			return root;
		}
		if(isInclude(root.left, u) && isInclude(root.left, v)){
			return query3(root.left, u, v);
		}
		if(isInclude(root.right, u) && isInclude(root.right, v)){
			return query3(root.right, u, v);
		}
		
		return root;
	}
	public boolean isInclude(Node root, Node n) {
		if(root == null){
			return false;
		}
		if(root == n){
			return true;
		}
		boolean leftFlag = isInclude(root.left, n);
		return leftFlag ? leftFlag : isInclude(root.right, n);
	}
	
	/*
	 * 如果没有指向父结点的指针
	 * 
	 * 
	 * 思路：
	 * 		后序遍历的思想,用栈保存到查找点的路径
	 * 		然后求两个栈第一个公共节点
	 */

//	public Node query4(Node root, Node u, Node v) {
//		if(root == null || u == null || v == null){
//			return null;
//		}
//		Stack<Node> stack1 = new Stack<>();
//		Stack<Node> stack2 = new Stack<>();
//		return root;
//	}
//	public void getNodePath(Node root, Node n, Stack<Node> stack){
//		if(root == null){
//			return;
//		}
//		Node t = root;
//		while(t != null){
//			stack.push(t);
//			if(t != n){
//				t = t.left;
//			}else{
//				return;
//			}
//		}
//		
//	}
	
	
}
