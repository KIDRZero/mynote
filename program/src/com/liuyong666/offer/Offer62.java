package com.liuyong666.offer;

public class Offer62 {
	/*
	 * ���л�������
	 * ��Ŀ����
	 * 		��ʵ�������������ֱ��������л��ͷ����л�������

	 */

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
        
  	}
    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        if(str == null || str.length() == 0 || index >= str.length()){
            return null;
        }
        TreeNode node = null;
        String[] strArr = str.split(",");
        if(!strArr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strArr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
  	}
}
