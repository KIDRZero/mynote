package com.liuyong666.offer;

public class Offer18 {
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }

	}
	/*
	 * ��Ŀ����
	 * �������Ŷ�����A��B���ж�B�ǲ���A���ӽṹ��
	 * 
	 * ������
	 * �����������㷨��Ӧ��
	 * ԭ�������Ƿ����ĳ��������ֻ��Ҫ�ж�ÿ������Ƿ��ڶ������г��ּ���
	 * ��һ������A���ҵ���B�ĸ�����ֵһ���Ľ��R
	 * �ڶ������ж���A����RΪ�����������ǲ��ǰ�������Bһ���Ľṹ
	 */
	//�жϸ����Ϊroot1�����Ƿ����root2�ṹ
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
    	//��ʼ����Ǳ���Ϊfalse
    	boolean hasSubtreeFlag = false;
    	
    	//���жϸ���㣬���������ж����ӣ�������Һ���
    	if(root1 != null && root2 != null){
    		if(root1.val == root2.val){
    			hasSubtreeFlag = nodesValEqual(root1,root2);
    		}
    		if(!hasSubtreeFlag){
    			hasSubtreeFlag = hasSubtree(root1.left,root2);
    		}
    		if(!hasSubtreeFlag){
    			hasSubtreeFlag = hasSubtree(root1.right,root2);
    		}
    	}
    	
    	return hasSubtreeFlag;
    }
	public  boolean nodesValEqual(TreeNode root1, TreeNode root2) {
		
		if(root2 == null){
			return true;
		}
		if(root1 == null){
			return false;
		}
		if(root1.val != root2.val){
			return false;
		}
		
		return nodesValEqual(root1.left,root2.left) && nodesValEqual(root1.right,root2.right);
	}

}
