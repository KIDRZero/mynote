package com.liuyong666.util;

public class PermutationAndCombination {

	/**
	 * ��X x Y�ķ����У������ϽǸ���Ϊ��㣬���½Ǹ���Ϊ�յ㣬ÿ��ֻ�������߻��������ߣ�����һ���ж����ֲ�ͬ���߷�
	 * ��������������int x,int y���뷵���߷���Ŀ����֤x��yС�ڵ���12��
	 * ����������
	 * 		2,2
	 * ���أ�
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
	  * n����վ�ӣ����ǵı�����δ�1��n��Ҫ����Ϊa���˱����ڱ��Ϊb���˵���ߣ�����Ҫ��һ�����ڣ����ʹ��ж������ŷ���
	  * �ڶ������Ҫ��a������b����ߣ�����һ��Ҫ���ڣ�����һ���ж������ŷ���
	  * ��������n�������˵ı��a��b���뷵��һ������Ԫ�ص����飬��������Ԫ������Ϊ��������Ĵ𰸡���֤����С�ڵ���10��
	  * ����������
	  * 		7,1,2
	  * ���أ�
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
	  * ����n�Ľ׳�
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
	  * ��һ���°����ˣ���һ��n����(���б������Ϊ1��n)�Ķ����У��������еı��Ϊb�ͱ��c���˶���ì�ܣ����������������վ�����ڵ�λ�á�
	  * ������������A��Ҫ��Ķ����ж����֣�
	  * ��������n�������˵ı��A,b��c���뷵������𰸣���֤����С�ڵ���11�Ҵ��ڵ���3��
	  * ����������
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
	  * n����ͬ���ǹ����ָ�m���ˣ�ÿ������һ�ţ����ж����ַַ���
	  * ����n��m���뷵�ط���������֤nС�ڵ���12����mС�ڵ���n��
	  * ����������
	  * 	10,3
	  * ���أ�
	  * 	36
	  * @param n	�ǹ���
	  * @param m	����
	  * @return		������
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
