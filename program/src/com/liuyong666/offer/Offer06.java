package com.liuyong666.offer;


public class Offer06 {

	/**
	 * 重建二叉树
	 * 题目描述：
	 * 		输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
	 * 		假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 		例如输入前序遍历序列{1,2,4,7,3,5,6,8}
	 * 		和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 */
	
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length < 1 || in.length < 1){
        	return null;
        }
        return constructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

	private TreeNode constructCore(int[] pre, int startPre, int endPre, 
			int[] in, int startIn, int endIn) {
		//前序遍历的第一个数字为根结点的值
		int rootValue = pre[startPre];
		TreeNode root = new TreeNode(rootValue);
		root.left = null;
		root.right = null;
		
		//只有一个结点，那么该结点就是根结点，直接返回
		if(startPre == endPre && startIn == endIn && pre[startPre] == in[startIn]){
				return root;
		}
		
		//在中序遍历中找到根结点
		int rootOfInorder = startIn;
		while(rootOfInorder <= endIn && in[rootOfInorder] != rootValue){
			rootOfInorder++;
		}
		
		//异常处理
		if(rootOfInorder == endIn && in[rootOfInorder] != rootValue){
			return null;
		}
		
		//计算左子树的长度
		int leftSubTreeLen = rootOfInorder - startIn;
		
		//根据左子树的长度计算前序遍历结果中左子树的最后一个结点的下标
		int leftIndexOfPreOrderEnd = startPre + leftSubTreeLen;
		
		//重建左子树
		if(leftSubTreeLen > 0){
			root.left = constructCore(pre, startPre + 1, leftIndexOfPreOrderEnd, 
					in, startIn, rootOfInorder - 1);
		}
		
		//重建右子树
		if(leftSubTreeLen < endPre - startPre){
			root.right = constructCore(pre, leftIndexOfPreOrderEnd + 1, endPre, 
					in, rootOfInorder + 1, endIn);
		}
		
		return root;
	}
}
