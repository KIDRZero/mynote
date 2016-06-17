package com.liuyong666.offer;

import java.util.Stack;

public class Offer63 {
	/*
	 * �����������ĵ�k�����
	 * ��Ŀ����
	 * 		����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣
	 * 		���磬
	 * 		 5 
	 * 		/ \ 
	 * 	  3    7 
	 * 	 /\   /\ 
	 * 	2 4  6 8 �У��������ֵ��С˳�����������ֵΪ4��
	 */
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//�ݹ�ⷨ
	int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null){
            return null;
        }
        TreeNode tmp = KthNode(pRoot.left, k);
        if(tmp != null){
            return tmp;
        }
        if(++count < k){
            return KthNode(pRoot.right, k);
        }else if(count == k){
            return pRoot;
        }
        return null;
    }
    
    //�ǵݹ�ⷨ
    TreeNode KthNode1(TreeNode pRoot, int k){
        if(pRoot == null){
            return null;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = pRoot;
        while(curNode != null || !stack.isEmpty()){
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }
            if(!stack.isEmpty()){
                curNode = stack.pop();
                count++;
                if(count == k){
                    return curNode;
                }
                curNode = curNode.right;
            }
        }
        return null;
    }

}
