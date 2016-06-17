package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer23 {

	/*
	 * 题目描述
	 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * 思路：
	 * 每一次打印一个结点的时候，如果该结点有子节点，则把该结点的子节点放到一个队列的末尾。
	 * 接下来到队列的头部取出最早进入队列的结点，重复前面的打印操作，直至队列中所有的结点都被打印出来为止
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
