package com.liuyong666.util;

public class PermutationAndCombination {

	/**
	 * 在X x Y的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
	 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
	 * 测试样例：
	 * 		2,2
	 * 返回：
	 * 		2
	 * @param x
	 * @param y
	 * @return
	 */
	 public int countWays(int x, int y) {
		 
		 x--;
		 y--;
		 int sum = 1;
		 for(int i = x + y; i > y; i--){
			 sum *= i;
		 }
		 for(int i = 2; i <= x; i++){
			 sum /= i;
		 }
		 
		 return sum;
	 }
	 
	 /**
	  * n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？
	  * 第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
	  * 给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
	  * 测试样例：
	  * 		7,1,2
	  * 返回：
	  * 		[2520,720]
	  * @param n
	  * @param a
	  * @param b
	  * @return
	  */
	 public int[] getWays(int n, int a, int b) {
	        int[] res = new int[2];
	        int total = 1;
	        for(int i = 2; i <= n; i++){
	            total *= i;
	        }
	        res[0] = total / 2;
	        
	        total = 1;
	        for(int i = 2; i < n; i++){
	            total *= i;
	        }
	        res[1] = total;
	        
	        return res;
	  }
	 
	 
	 /**
	  * 返回n的阶乘
	  * @param n
	  * @return
	  */
	 public int getNum(int n){
	        
	        int ans=1;
	        for (int i=2; i<=n; ++i) {
	            ans*=i;
	        }
	        return ans;
	 }
	 /**
	  * 是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。
	  * 现在问你满足A的要求的对列有多少种？
	  * 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
	  * 测试样例：
	  * 		6,1,2,3
	  * 
	  * 288
	  * @param n
	  * @param A
	  * @param b
	  * @param c
	  * @return
	  */
	 public int getWays(int n, int A, int b, int c) {
		 return getNum(n)-4*getNum(n-1)+2*getNum(n-2);
	 }
	 
	 /**
	  * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
	  * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
	  * 测试样例：
	  * 	10,3
	  * 返回：
	  * 	36
	  * @param n	糖果数
	  * @param m	人数
	  * @return		方案数
	  */
	 public int getWays(int n, int m) {
	        n--;
	        m--;
	        int zi = 1;
	        for(int i = n; i > n - m; i--){
	            zi *= i;
	        }
	        return zi / getNum(m);
	 }
}
