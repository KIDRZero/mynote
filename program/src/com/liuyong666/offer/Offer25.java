package com.liuyong666.offer;

import java.util.ArrayList;

public class Offer25 {
	/*
	 * �������к�Ϊĳһֵ��·��
	 * 
	 * ��Ŀ����
	 * 		����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
	 * 		·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
	 * ˼·��
	 * 		������������������Ľ��ŵ�A������
	 * 		��������Ҷ�ӽ�㲢�Һ�ǡ����Ŀ��ֵʱ�����������������н��ŵ�B�����У�B�������������һ��·����
	 * 		���������Ҷ�ӽ�����Ȼ������Ŀ��ֵ����ô���Ƴ�A��������ӵĽ�㣬�޸ĺͣ��л����Һ��ӽ�����¼���
	 * 		���û�б�����Ҷ�ӽ��ʹӺ��ӽ���м���Ѱ��������·��
	 */
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        /*
         * currentSum	��¼��ǰ��
         * pathNodes	���浱ǰ·��ɨ����Ľ��
         * pathList		�������������ĸ���·��
         */
		int currentSum = 0;
		ArrayList<Integer> pathNodes = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		
		if(root == null){
			return pathList;
		}
		
		return findPath(pathList,pathNodes,root,target,currentSum);
    }

	private ArrayList<ArrayList<Integer>> findPath(
			ArrayList<ArrayList<Integer>> pathList,
			ArrayList<Integer> pathNodes,
			TreeNode root, 
			int target, 
			int currentSum) {
		
		currentSum += root.val;
		pathNodes.add(root.val);
		boolean isLeafNode = root.left == null && root.right == null;
		//�����Ҷ�ӽ�㲢�ҵ���Ŀ��ֵ����ѵ�ǰ��·����ӵ�pathList��
		if(currentSum == target && isLeafNode){
			ArrayList<Integer> nodes = new ArrayList<Integer>();
			for(Integer node : pathNodes){
				nodes.add(node);
			}
			pathList.add(nodes);
		}
		//�������Ҷ�ӽ������������ӽ��
		if(root.left != null){
			findPath(pathList, pathNodes, root.left, target, currentSum);
		}
		if(root.right != null){
			findPath(pathList, pathNodes, root.right, target, currentSum);
		}
		
		//�ڷ��ظ��ڵ�֮ǰ����·����ɾ����ǰ���
		Integer node = pathNodes.remove(pathNodes.size() - 1);
		currentSum -= node;
		
		
		return pathList;
	}
	
	

}
