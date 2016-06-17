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
	 * 题目描述
	 * 输入两颗二叉树A，B，判断B是不是A的子结构。
	 * 
	 * 解析：
	 * 二叉树遍历算法的应用
	 * 原二叉树是否具有某棵子树，只需要判断每个结点是否都在二叉树中出现即可
	 * 第一步在树A中找到和B的根结点的值一样的结点R
	 * 第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构
	 */
	//判断根结点为root1的树是否包含root2结构
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
    	//初始化标记变量为false
    	boolean hasSubtreeFlag = false;
    	
    	//先判断根结点，若不包含判断左孩子，其次是右孩子
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
