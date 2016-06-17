package com.liuyong666.offer;

import java.util.Stack;

public class Offer50 {
	/*
	 * �����������LCA����
	 * ��������
	 * 		���и��������������ڵ������������ȡ�
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
	//���������
	/*
	 * �����ǰ���t ���ڽ��u��v��˵��u��v����t ����࣬�������ǵĹ�ͬ���ȱض���t ���������У��ʴ�t ���������м������ң�
	 * �����ǰ���t С�ڽ��u��v��˵��u��v����t ���Ҳ࣬�������ǵĹ�ͬ���ȱض���t ���������У��ʴ�t ���������м������ң�
	 * �����ǰ���t ���� u <t < v��˵��u��v�־���t �����࣬�ʵ�ǰ���t ��Ϊ����������ȣ�
	 * �����u��v�����ȣ���ô����u�ĸ���㣬ͬ�����v��u�����ȣ���ô����v�ĸ���㡣
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
		//����������ڣ������������ҽ�㣬����
		if(left > right){
			int temp = left;
			left = right;
			right = temp;
		}
		while (true) {    
	        //���tС��u��v����t���������в���  
	        if (t.value < left) {    
	            t = t.right;    

	        //���t����u��v����t���������в���  
	        } else if (t.value > right) {    
	            t = t.left;    
	        } else {    
	            return t;    
	        }    
	    } 
	}
	
	/*
	 * ���Ƕ��������
	 * 
	 * �����������Ƕ����������ֻ��һ����ͨ�Ķ������أ�
	 * ���ÿ����㶼��һ��ָ��ָ�����ĸ���㣬�������ǿ��Դ��κ�һ�����������õ�һ�������������ĵ�����������������ת��Ϊ������������ĵ�һ��������㡣
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
	 * ���û��ָ�򸸽���ָ��
	 * 
	 * ����ⷨ��������ظ�����
	 * ����������ڵ㣬LCA��������õݹ�ܿ�������������������һ�㶼����ת��Ϊ�ݹ飨��Ϊ���������ǵݹ����������ο��������£�
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
	 * ���û��ָ�򸸽���ָ��
	 * 
	 * 
	 * ˼·��
	 * 		���������˼��,��ջ���浽���ҵ��·��
	 * 		Ȼ��������ջ��һ�������ڵ�
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
