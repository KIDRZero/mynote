package com.liuyong666.util;

import java.util.Random;

public class Probability {
	/*
	 * 足球比赛练习题
	 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
	 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
	 * 测试样例：
	 * 		4
	 * 返回：
	 * 		[3,7]
	 */
	public int[] calc(int k) {

        if(k == 2){
            return new int[]{0,1};
        }
    	int mu = 1;
    	for(int i = 2 * k - 1; i >= 3; i -= 2){
    		mu *= i;
    	}
    	
    	int zi = mu - getNum(k + 1) / getNum(2);

        int gg = gcd(zi, mu);
    	return new int[]{zi / gg,mu / gg};
    }
    
    /**
	  * 返回n的阶乘
	  * @param n
	  * @return
	  */
	 public static int getNum(int n){
	        
	        int ans=1;
	        for (int i=2; i<=n; ++i) {
	            ans*=i;
	        }
	        return ans;
	 }
    public static int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
    /*
     * 蚂蚁问题
     * n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
     * 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
     * 测试样例：
     * 		3
     * 返回：
     * 		[3,4]
     */
    public int[] collision(int n) {
    	
    	int mu = 1 << (n - 1);
    	return new int[]{mu - 1, mu};
    }
    
    /*
     * 随机函数练习题
     * 给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，请实现等概率随机产生1~7的随机函数。
     * (给定一个可调用的Random5::random()方法,可以等概率地随机产生1～5的随机函数)
     */
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }
    
    // 通过rand5实现rand7
    public int random7var5() {
    	int a = (rand5() - 1) * 5 + (rand5() - 1);
    	while(a >= 21){
    		a = (rand5() - 1) * 5 + (rand5() - 1);
    	}
    	return a % 7 + 1;
    }

    /*
     * 随机01练习题
     * 给定一个以p概率产生0，以1-p概率产生1的随机函数RandomP::f()，p是固定的值，但你并不知道是多少。
     * 除此之外也不能使用任何额外的随机机制，请用RandomP::f()实现等概率随机产生0和1的随机函数。
     */
    private static double p = new Random().nextFloat();
    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // 通过f函数实现01等概率返回
    	while(true){
    		int a = f();
    		int b = f();
    		if(a != b){
    			return a > b ? 1 : 0;
    		}
    	}
    }
    
    /*
     * 随机区间函数练习题
     * 假设函数f()等概率随机返回一个在[0,1)范围上的浮点数，
     * 那么我们知道，在[0,x)区间上的数出现的概率为x(0<x≤1)。
     * 给定一个大于0的整数k，并且可以使用f()函数，
     * 请实现一个函数依然返回在[0,1)范围上的数，但是在[0,x)区间上的数出现的概率为x的k次方。
     */
    class RandomSeg {
        private Random rand = new Random(12345);
        public double f() {
            return rand.nextFloat();
        }
        // 请调用f()函数实现
        public double random(int k, double x) {
        	double m = -1;
        	for(int i = 0; i < k; i++){
        		m = Math.max(m, f());
        	}
            return m;
        }
    }
    
    /*
     * 随机数组打印练习题
     * 
     * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
     */
    class RandomPrint {
        public int[] print(int[] arr, int N, int M) {
        	int[] res = new int[M];
        	for(int i = 0; i < M; i++){
        		int pos = new Random().nextInt(12345) % (N - i);
        		res[i] = arr[pos];
        		swap(arr, pos, N - i - 1);
        	}
        	return res;
        }

		private void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
    }
    
    /*
     * 机器吐球练习题
     * 有一个机器按自然数序列的方式吐出球，1号球，2号球，3号球等等。
     * 你有一个袋子，袋子里最多只能装下K个球，并且除袋子以外，你没有更多的空间，一个球一旦扔掉，就再也不可拿回。
     * 
     * 设计一种选择方式，使得当机器吐出第N号球的时候，你袋子中的球数是K个，
     * 
     * 同时可以保证从1号球到N号球中的每一个，被选进袋子的概率都是K/N。
     * 举一个更具体的例子，有一个只能装下10个球的袋子，当吐出100个球时，袋子里有10 球，
     * 并且1~100号中的每一个球被选中的概率都是10/100。
     * 然后继续吐球，当吐出1000个球时，袋子里有 10 个球，并且1~1000号中的每一个球被选中的概率都是10/1000。
     * 继续吐球，当吐出i个球时，袋子里有10个球，并且1~i号中的每一个球被选中的概率都是10/i。
     * 也就是随着N的变化，1~N号球被选中的概率动态变化成k/N。请将吐出第N个球时袋子中的球的编号返回。
     */
    static class Bag {
        private int [] selected = null;
        private static Random rand = new Random(12345);
        private boolean flag = true;
        // 每次拿一个球都会调用这个函数，N表示第i次调用
        public int[] carryBalls(int N, int k) {
        	if(flag){
        		selected = new int[k];
        		flag = false;
        	}
        	if(N <= k){
        		selected[N - 1] = N;
        	}else if(rand.nextInt(N) < k){
        		int pos = rand.nextInt(k);
        		selected[pos] = N;
        	}
            return selected;
        }
    }
    public static void main(String[] args) {
		new Probability().new RandomPrint().print(new int[]{29,24,17,1,3,11,8,19,12,15,10,28,20,18,2,26,14,7,22,27,23,5,6,9,21,16,25,4,13}, 29, 10);
	}
}
