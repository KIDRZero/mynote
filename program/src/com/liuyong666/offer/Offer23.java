package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer23 {

	/*
	 * ��Ŀ����
	 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
	 * ˼·��
	 * ÿһ�δ�ӡһ������ʱ������ý�����ӽڵ㣬��Ѹý����ӽڵ�ŵ�һ�����е�ĩβ��
	 * �����������е�ͷ��ȡ�����������еĽ�㣬�ظ�ǰ��Ĵ�ӡ������ֱ�����������еĽ�㶼����ӡ����Ϊֹ
	 */
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}
