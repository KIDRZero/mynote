package com.liuyong666.util;

import java.util.Random;

public class Probability {
	/*
	 * ���������ϰ��
	 * ��2kֻ��ӣ���k-1��ǿ�ӣ����඼�����ӣ���������Ƿֳ�k�������ÿ�������ӣ�����ǿ�����ĸ����Ƕ��
	 * ����һ����k���뷵��һ�����飬����������Ԫ�أ��ֱ�Ϊ���ս���ķ��Ӻͷ�ĸ���뻯��������
	 * ����������
	 * 		4
	 * ���أ�
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
	  * ����n�Ľ׳�
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
     * ��������
     * nֻ���ϴ���n���ε�n���������ű��ƶ����ٶ�����ͬ�ģ���������ͷ�ĸ����Ƕ��٣�
     * ����һ��������n���뷵��һ�����飬��������Ԫ�طֱ�Ϊ����ķ��Ӻͷ�ĸ���뻯Ϊ��������
     * ����������
     * 		3
     * ���أ�
     * 		[3,4]
     */
    public int[] collision(int n) {
    	
    	int mu = 1 << (n - 1);
    	return new int[]{mu - 1, mu};
    }
    
    /*
     * ���������ϰ��
     * ����һ���ȸ����������1~5���������������֮�⣬����ʹ���κζ����������ƣ���ʵ�ֵȸ����������1~7�����������
     * (����һ���ɵ��õ�Random5::random()����,���Եȸ��ʵ��������1��5���������)
     */
    private static Random rand = new Random(123456);
    // �������[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }
    
    // ͨ��rand5ʵ��rand7
    public int random7var5() {
    	int a = (rand5() - 1) * 5 + (rand5() - 1);
    	while(a >= 21){
    		a = (rand5() - 1) * 5 + (rand5() - 1);
    	}
    	return a % 7 + 1;
    }

    /*
     * ���01��ϰ��
     * ����һ����p���ʲ���0����1-p���ʲ���1���������RandomP::f()��p�ǹ̶���ֵ�����㲢��֪���Ƕ��١�
     * ����֮��Ҳ����ʹ���κζ����������ƣ�����RandomP::f()ʵ�ֵȸ����������0��1�����������
     */
    private static double p = new Random().nextFloat();
    // �������p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // ͨ��f����ʵ��01�ȸ��ʷ���
    	while(true){
    		int a = f();
    		int b = f();
    		if(a != b){
    			return a > b ? 1 : 0;
    		}
    	}
    }
    
    /*
     * ������亯����ϰ��
     * ���躯��f()�ȸ����������һ����[0,1)��Χ�ϵĸ�������
     * ��ô����֪������[0,x)�����ϵ������ֵĸ���Ϊx(0<x��1)��
     * ����һ������0������k�����ҿ���ʹ��f()������
     * ��ʵ��һ��������Ȼ������[0,1)��Χ�ϵ�����������[0,x)�����ϵ������ֵĸ���Ϊx��k�η���
     */
    class RandomSeg {
        private Random rand = new Random(12345);
        public double f() {
            return rand.nextFloat();
        }
        // �����f()����ʵ��
        public double random(int k, double x) {
        	double m = -1;
        	for(int i = 0; i < k; i++){
        		m = Math.max(m, f());
        	}
            return m;
        }
    }
    
    /*
     * ��������ӡ��ϰ��
     * 
     * ����һ������ΪN��û���ظ�Ԫ�ص�����arr��һ������M��ʵ�ֺ����ȸ��������ӡarr�е�M������
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
     * ����������ϰ��
     * ��һ����������Ȼ�����еķ�ʽ�³���1����2����3����ȵȡ�
     * ����һ�����ӣ����������ֻ��װ��K���򣬲��ҳ��������⣬��û�и���Ŀռ䣬һ����һ���ӵ�������Ҳ�����ûء�
     * 
     * ���һ��ѡ��ʽ��ʹ�õ������³���N�����ʱ��������е�������K����
     * 
     * ͬʱ���Ա�֤��1����N�����е�ÿһ������ѡ�����ӵĸ��ʶ���K/N��
     * ��һ������������ӣ���һ��ֻ��װ��10����Ĵ��ӣ����³�100����ʱ����������10 ��
     * ����1~100���е�ÿһ����ѡ�еĸ��ʶ���10/100��
     * Ȼ��������򣬵��³�1000����ʱ���������� 10 ���򣬲���1~1000���е�ÿһ����ѡ�еĸ��ʶ���10/1000��
     * �������򣬵��³�i����ʱ����������10���򣬲���1~i���е�ÿһ����ѡ�еĸ��ʶ���10/i��
     * Ҳ��������N�ı仯��1~N����ѡ�еĸ��ʶ�̬�仯��k/N���뽫�³���N����ʱ�����е���ı�ŷ��ء�
     */
    static class Bag {
        private int [] selected = null;
        private static Random rand = new Random(12345);
        private boolean flag = true;
        // ÿ����һ���򶼻�������������N��ʾ��i�ε���
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
