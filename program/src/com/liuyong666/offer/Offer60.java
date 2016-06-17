package com.liuyong666.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer60 {
	/*
	 * �Ѷ�������ӡ�ɶ���
	 * ��Ŀ����
	 * 		���ϵ��°����ӡ��������ͬһ����������������
	 * 		ÿһ�����һ�С�
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
        //��һ��Ľ����
        int nextLevel = 0;
        //��ǰ���л�û�д�ӡ�Ľ����
        int toBePrinted = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            //��ӵ���ӡ���б���
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
            	//�ѵ�ǰ����ӵ����б��У�����������
                totalList.add(rowList);
                rowList = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return totalList;
    }

}
