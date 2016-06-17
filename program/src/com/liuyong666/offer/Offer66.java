package com.liuyong666.offer;

public class Offer66 {
	/**
	 * 矩阵中的路径
	 * 题目描述：
	 * 		请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
	 * 		路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
	 * 		如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
	 * 		例如 		a b c e
	 * 			 	s f c s 
	 * 				a d e e 
	 * 		矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
	 * 		因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
	 * 思路：
	 * 		回溯法。
	 * 		所谓回溯法就是按选优条件向前搜索，以达到目标。
	 * 		但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择。
	 * 		具体到这道题目就是对于每个字符，如果在矩阵中找到了其在矩阵中的位置，
	 * 		进行下一次寻找的时候，可以从上、下、左、右四个方向（边界元素除外）进行递归寻找，如果找到了则继续寻找下一个字符；
	 * 		如果没有找到的话，则回到上一个字符重新寻找。直到找到全部字符在矩阵中对应的位置。
	 * 
	 */
	/*
	 *  基本思路是创建一个布尔数组，用于记录矩阵中已经访问过的标记。 
	 *  对于路径中的第i个字符，除了边界的元素外，
	 *  其他位置的元素都有上、下、左、右四个相邻的位置。
	 *  那么路径中的第i+1个字符可 以从这四个位置中寻找得到。依此进行递归，直到找到最后一个字符 在矩阵中的位置为止。
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
	    // 创建一个布尔数组
	    boolean[] visited = new boolean[matrix.length];
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            if (hasPathCore(matrix, rows, cols, i, j, 0, str, visited)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	private boolean hasPathCore(char[] matrix, int rows, int cols, int i,
	        int j, int k, char[] str, boolean[] visited) {
		
	    // 对于给定行数和列数得到其在矩阵中的下标
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k]
		        || visited[index])
		    return false;
		visited[index] = true;
		// 如果递归到最后一个位置的字符，则表明前面位置的字符都在矩阵中找到了对应的位置
		if (k == str.length - 1)
		    return true;
		// 如果没有递归到最后一个位置的字符，则继续递归,k+1表示继续在矩阵中寻找str数组中下一个位置的字符在矩阵中的位置
		if (hasPathCore(matrix, rows, cols, i - 1, j, k + 1, str, visited)
		        || hasPathCore(matrix, rows, cols, i + 1, j, k + 1, str, visited)
		        || hasPathCore(matrix, rows, cols, i, j - 1, k + 1, str, visited)
		        || hasPathCore(matrix, rows, cols, i, j + 1, k + 1, str, visited)) {
		    return true;
		}else{
		    //如果相邻格子的字符都没有匹配到下一个字符，则需要回到前一个格子，从而需要把把位置的状态重新设定为未访问
		        k--;
		        visited[index] = false;
		}
		return false;
	}
}
