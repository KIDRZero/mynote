package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer60 {
	/*
	 * 把二叉树打印成多行
	 * 题目描述
	 * 		从上到下按层打印二叉树，同一层结点从左至右输出。
	 * 		每一层输出一行。
	 */
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        ArrayList<Integer> rowList = new ArrayList<>();
        if(pRoot == null){
            return totalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        //下一层的结点数
        int nextLevel = 0;
        //当前层中还没有打印的结点数
        int toBePrinted = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            //添加到打印行列表中
            rowList.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextLevel++;
            }
            queue.poll();
            toBePrinted--;
            if(toBePrinted == 0){
            	//把当前行添加到总列表中，并创建新行
                totalList.add(rowList);
                rowList = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return totalList;
    }

}
