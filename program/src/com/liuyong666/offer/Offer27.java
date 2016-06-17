package com.liuyong666.offer;


public class Offer27 {
	/*
	 * 
	 * ������������˫������
	 * ��Ŀ������
	 * 		����һ�ö��������������ö���������ת����һ�������˫������
	 * 		Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
	 * ˼·��
	 * 		���ڶ��������������������������ģ�����ǹ��쵥����ֻ��Ҫһ����������Ϳ�����
	 * 		��������Ҫ����˫����Ҳ��������������Ĺ�������Ҫ����ÿ������left��rightָ�룬�����������������������ָ��
	 * 		������������һ���ص㣬���Ǹ����������������н�㶼�ȸ�����ֵС�����������ϵ����н���ֵ���ȸ�����ֵ��
	 * 		����������ʣ����������������ӵ�ʱ�򣬿��Լ������䵱���������ĸ���㣬�Һ��ӿ��Ե����������ĸ���㣬�Ӷ�ʹ�õݹ����
	 * 
	 * 		��������Ϊ�������η��ʽ������ӣ���������Ҷ�ӽڵ��ʱ�򣬵ݹ���������Ѹ�Ҷ�ӽ����Ϊ������ת����˫����ĵ�һ�����
	 * 		Ȼ����丸����������ұߣ�����left��rightָ�룻�����������Һ��ӣ�����������Һ��Ӽ���ת�������ڸ������ұ�(�������Һ��ӿ϶��ȸ�����)
	 * 		����������������ת����ɺ󣬷���˫����ĵ�һ�����Ϳ�����
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
        
        //��λ��������˫��������һ�����
        while(p != null && p.right != null){
        	p = p.right;
        }
        
        //��root���׷�ӵ�������˫��������һ�����
        if(pLastNodeOfLeftList != null){
        	p.right = pRootOfTree;
        	pRootOfTree.left = p;
        }
        
        //ת��������Ϊ˫����
        TreeNode pLastNodeOfRightList = convert(pRootOfTree.right);
        //��root׷����������˫��������һ�����
        if(pLastNodeOfRightList != null){
        	pLastNodeOfRightList.left = pRootOfTree;
        	pRootOfTree.right = pLastNodeOfRightList;
        }
        //�����������ĵ�һ�����
        if(pLastNodeOfLeftList != null){
        	return pLastNodeOfLeftList;
        }
         
    	return pRootOfTree;
    }

}
