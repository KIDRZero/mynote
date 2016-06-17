package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer61 {
	/*
	 * 按之字形顺序打印二叉树
	 * 题目描述
	 * 		请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
	 * 		第二层按照从右至左的顺序打印，
	 * 		第三行按照从左到右的顺序打印，其他行以此类推。
	 * 
	 */
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > totalList = new ArrayList<>();
        ArrayList<Integer> rowList = new ArrayList<>();
        if(pRoot == null){
            return totalList;
        }
        boolean isLeftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int nextLevel = 0;
        int toBePrinted = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
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
                if(!isLeftToRight){
                    reverse(rowList);
                }
                //下一行需要改变方向
                isLeftToRight = !isLeftToRight;
                totalList.add(rowList);
                rowList = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return totalList;

    }
    private void reverse(ArrayList<Integer> list){
        if(list == null || list.size() == 0){
            return;
        }
        int size = list.size();
        for(int i = 0; i < (size + 1) / 2; i++){
			int temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }


}
