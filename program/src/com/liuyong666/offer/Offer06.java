package com.liuyong666.offer;


public class Offer06 {

	/**
	 * �ؽ�������
	 * ��Ŀ������
	 * 		����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
	 * 		���������ǰ���������������Ľ���ж������ظ������֡�
	 * 		��������ǰ���������{1,2,4,7,3,5,6,8}
	 * 		�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
		//ǰ������ĵ�һ������Ϊ������ֵ
		int rootValue = pre[startPre];
		TreeNode root = new TreeNode(rootValue);
		root.left = null;
		root.right = null;
		
		//ֻ��һ����㣬��ô�ý����Ǹ���㣬ֱ�ӷ���
		if(startPre == endPre && startIn == endIn && pre[startPre] == in[startIn]){
				return root;
		}
		
		//������������ҵ������
		int rootOfInorder = startIn;
		while(rootOfInorder <= endIn && in[rootOfInorder] != rootValue){
			rootOfInorder++;
		}
		
		//�쳣����
		if(rootOfInorder == endIn && in[rootOfInorder] != rootValue){
			return null;
		}
		
		//�����������ĳ���
		int leftSubTreeLen = rootOfInorder - startIn;
		
		//�����������ĳ��ȼ���ǰ���������������������һ�������±�
		int leftIndexOfPreOrderEnd = startPre + leftSubTreeLen;
		
		//�ؽ�������
		if(leftSubTreeLen > 0){
			root.left = constructCore(pre, startPre + 1, leftIndexOfPreOrderEnd, 
					in, startIn, rootOfInorder - 1);
		}
		
		//�ؽ�������
		if(leftSubTreeLen < endPre - startPre){
			root.right = constructCore(pre, leftIndexOfPreOrderEnd + 1, endPre, 
					in, rootOfInorder + 1, endIn);
		}
		
		return root;
	}
}
