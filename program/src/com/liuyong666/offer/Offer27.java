package com.liuyong666.offer;


public class Offer27 {
	/*
	 * 
	 * 二叉搜索树与双向链表
	 * 题目描述：
	 * 		输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	 * 		要求不能创建任何新的结点，只能调整树中结点指针的指向。
	 * 思路：
	 * 		由于二叉搜索树的中序遍历就是排序的，如果是构造单链表，只需要一次中序遍历就可以了
	 * 		但现在需要构造双链表，也就是在中序遍历的过程中需要设置每个结点的left与right指针，现在问题是如何设置这两个指针
	 * 		二叉搜索树有一个特点，就是根结点的左子树上所有结点都比根结点的值小，而右子树上的所有结点的值都比根结点的值大
	 * 		利用这个性质，当遍历根结点的左孩子的时候，可以继续把其当做左子树的根结点，右孩子可以当做右子树的根结点，从而使用递归完成
	 * 
	 * 		依左子树为例，依次访问结点的左孩子，当遍历到叶子节点的时候，递归结束，并把该叶子结点设为左子树转换的双链表的第一个结点
	 * 		然后把其父结点链在其右边，设置left和right指针；如果父结点有右孩子，则继续对其右孩子继续转换，链在父结点的右边(父结点的右孩子肯定比父结点大)
	 * 		这样当左右子树都转换完成后，返回双链表的第一个结点就可以了
	 * 
	 */
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
        	return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
        	return pRootOfTree;
        }
        
        TreeNode pLastNodeOfLeftList = convert(pRootOfTree.left);
        TreeNode p = pLastNodeOfLeftList;
        
        //定位到左子树双链表的最后一个结点
        while(p != null && p.right != null){
        	p = p.right;
        }
        
        //将root结点追加到左子树双链表的最后一个结点
        if(pLastNodeOfLeftList != null){
        	p.right = pRootOfTree;
        	pRootOfTree.left = p;
        }
        
        //转换右子树为双链表
        TreeNode pLastNodeOfRightList = convert(pRootOfTree.right);
        //将root追加至右子树双链表的最后一个结点
        if(pLastNodeOfRightList != null){
        	pLastNodeOfRightList.left = pRootOfTree;
        	pRootOfTree.right = pLastNodeOfRightList;
        }
        //返回左子树的第一个结点
        if(pLastNodeOfLeftList != null){
        	return pLastNodeOfLeftList;
        }
         
    	return pRootOfTree;
    }

}
