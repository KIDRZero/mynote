package com.liuyong666.offer;

public class Offer39_1 {
	/*
	 * 二叉树的深度
	 * 
	 * 题目描述：
	 * 		输入一棵二叉树，求该树的深度。
	 * 		从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
	 */
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public int TreeDepth(TreeNode pRoot)
    {
		if(pRoot == null){
			return 0;
		}
		if(pRoot.left == null && pRoot.right == null){
			return 1;
		}
		int leftSubtreeDepth = TreeDepth(pRoot.left);
		int RightSubtreeDepth = TreeDepth(pRoot.right);
		int maxSubtreeDepth = leftSubtreeDepth > RightSubtreeDepth ? leftSubtreeDepth : RightSubtreeDepth;
		
		return maxSubtreeDepth + 1;
    }

}
