package com.liuyong666.offer;

public class Offer39_1 {
	/*
	 * �����������
	 * 
	 * ��Ŀ������
	 * 		����һ�ö����������������ȡ�
	 * 		�Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
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
