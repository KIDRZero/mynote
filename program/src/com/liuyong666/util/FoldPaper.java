package com.liuyong666.util;

import java.util.ArrayList;
import java.util.List;

public class FoldPaper {
	
	/*
	 * 折纸问题
	 * 
	 * 		请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。
	 * 		此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
	 * 		突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。
	 * 		如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
	 * 
	 * 		给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
	 * 		测试样例：
	 * 			1
	 * 		返回：["down"]
	 */
	public static void main(String[] args) {
		new FoldPaper().foldPaper1(4);
	}
    public String[] foldPaper(int n) {

        int length = 1;
        for (int i = 0; i < n; i++) {
            length = 2 * length;
        }
        length = length - 1;// 计算折痕数为2^n-1
        String[] fold = new String[length];  if (n == 1) {
            fold[0] = "down";// 只有一个折痕时
            return fold;
        } else if (n > 1) {
            fold[0] = "down";
            for (int j = 1; j <= (length / 2); j = (j * 2) + 1) {
                fold[j] = "down";// 每次第(length+1)/2个折痕都为"down",并根据该折痕为中心点两侧相对
                for (int k = j; k > 0; k--) {
                    if (fold[j - k].equals("down")) {
                        fold[j + k] = "up";
                    } else {
                        fold[j + k] = "down";
                    }
                }
            }
            return fold;
        } else {
            return null;
        }
    }
    
    
    /*
     * 给一个很长很窄的纸条，把纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开，此时折痕是凹下去的，也就是突起的方向指向纸条的下方； 
		如果从纸条的下边向上方对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是：下折痕、下折痕、上折痕； 
		如果纸条每次都从下边向上方对折，在对折n次之后展开。此时所有折痕突起的方向是什么样的呢？ 
		请写一个函数，输入一个整数代表纸条的对折次数记为fTimes，从上到下依次打印所有折痕的突起方向。 
		例如： 
		fTimes = 1 
		打印：down 
		fTimes = 2 
		打印：down down up
			提示：折痕其实是二叉树结构。
				该二叉树的特点是：根节点是下，每一个节点的左节点是下，右节点是上。
				该二叉树的中序遍历即为答案，但不需要构造一颗二叉树，用递归方法可打印出来。
     */
    public String[] foldPaper1(int n) {
        List<String> node=new ArrayList<String>();
        String[] result=new String[(int) (Math.pow(2, n) - 1)];
        
        Push(node,n,"down");
         
        for (int i = 0; i < node.size(); i++) {
            result[i]=node.get(i);
             
        }
 
        return result;
    }
    private void Push(List<String> node, int n, String string) {
        if (n==0) {
            return;
        }
         
        Push(node, n-1, "down");
        node.add(string);
        Push(node, n-1, "up");
    }
    
    
}
