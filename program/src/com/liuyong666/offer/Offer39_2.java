package com.liuyong666.offer;

import com.liuyong666.offer.Offer39_1.TreeNode;

public class Offer39_2 {
	/*
	 * ƽ�������
	 * ��Ŀ����
	 * 		����һ�ö��������жϸö������Ƿ���ƽ���������
	 */

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
	        this.val = val;
	    }
	}
	//��һ��������һ���TreeDepth����
	public boolean IsBalanced(TreeNode root) {
        if(root == null){
        	return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if(diff > 1 || diff < -1){
        	return false;
        }
		return IsBalanced(root.left) && IsBalanced(root.right);
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
	
	//������ÿ�����ֻ����һ�飬��������ķ�ʽ
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root, new Holder());
	}
	private boolean isBalanced(TreeNode root, Holder holder) {
		if(root == null){
			holder.depth = 0;
			return true;
		}
		Holder left = new Holder();
		Holder right = new Holder();
		if(isBalanced(root.left, left) && isBalanced(root.right, right)){
			int diff = left.depth - right.depth;
			holder.depth = (left.depth > right.depth ? left.depth : right.depth) + 1;
			if(diff <= 1 && diff >= -1){
				return true;
			}
		}
		return false;
	}
	private class Holder{
		int depth;
	}
	
}
