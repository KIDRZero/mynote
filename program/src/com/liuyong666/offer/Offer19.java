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
	 * �����һ������������һ����������������ľ���
	 * ��������:
�������ľ����壺Դ������ 
    	      8
    	    /   \
    	   6    10
    	  / \   / \
    	 5   7 9  11
    	���������
    	      8
    	    /   \
    	   10    6
    	  / \   / \
    	 11  9 7   5
     *
     *˼·��
     *���������������ÿ�����
     *���������Ľ�����ӽ�㣬�ͽ������������ӽ��
     *�����������з�Ҷ�ӽڵ�������ӽڵ�֮�󣬾͵õ������ľ���
	 */
	//�ݹ�ʵ��
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
    
    //�ǵݹ�ʵ��
    public void mirror2(TreeNode root) {
    	if(root == null || (root.left == null && root.right == null)){
    		return ;
    	}
    	
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	while(!s.isEmpty()){
    		TreeNode node = s.pop();
    		
    		//�������Һ��ӽ��
    		TreeNode nodeTemp = node.left;
    		node.left = node.right;
    		node.right = nodeTemp;
    		
    		//����������
    		if(node.left != null){
    			s.push(node.left);
    		}
    		
    		//����������
    		if(node.right != null){
    			s.push(node.right);
    		}
    		
    	}
    }

}
