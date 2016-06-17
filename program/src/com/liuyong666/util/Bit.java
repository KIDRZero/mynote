package com.liuyong666.util;
import static java.lang.System.*;
import static java.lang.Math.*;
public class Bit {
	/**
	 * 不用比较求出两数较大值
	 * @param a		参数a
	 * @param b		参数b
	 * @return		返回两参数较大的值
	 */
	public static int getGreater(int a, int b){
		/* 获得两参数差的符号位 */
		int flag = ((a - b) >> 31) & 0x01;
		return flag * b + (1 - flag) * a;
	}
	
	/**
	 * 一个数组中只有一个数出现奇数次，其他都是偶数次，找出这个数
	 * @param a	数组
	 * @return	只出现奇数次的数
	 */
	public static int findOddTimesNum(int[] a){
		
		int res = a[0];
		for(int i = 1; i < a.length; i++){
			res ^= a[i];
		}
		return res;
	}
	
	/**
	 * 由n个元素组成的数组，n-2个数出现了偶数次，两个数出现了奇数次，且这两个数不相等,如何用O(1)的空间复杂度，找出这两个数
	 * @param a 数组
	 * @return	出现奇数次的两个数
	 */
	public static int[] findOddTimesTwoNums(int[] arr){
		
        int res = arr[0];
        for(int i = 1; i < arr.length; i++){
            res ^= arr[i];
        }
        //把异或结果保存
        int save_res = res;
        
        //假设a数组中x和y出现了奇数次，则有  res = x ^ y
        //因为x和y不一样，则x和y的第k位一定不一样，满足res的第k位为1，寻找k
        int k = 0;
        while((res & 0x01) != 1){
            res >>= 1;
            k++;
        }
        
        int _res = 0;
        //_res与数组中第k位为1的那些整数进行异或
        for(int i = 0; i < arr.length; i++){
            if(((arr[i] >> k) & 0x01) == 1){
                _res ^= arr[i];
            }
        }
		
		//异或完成后，_res为x或y中的一个，另一个数为_res ^ save_res
		return new int[]{_res, _res ^ save_res};
	}
	
	/**
	 * 不用任何额外变量交换两个整数的值(加减实现，缺点是可能溢出)
	 * @param num	拥有两个元素的数组
	 * @return		交换后的数组
	 */
	public int[] swapVarAdd(int[] num) {
        num[0] = num[0] + num[1];
        num[1] = num[0] - num[1];
        num[0] = num[0] - num[1];
        return num;
    }
	
	/**
	 * 不用任何额外变量交换两个整数的值(异或实现)
	 * @param num	拥有两个元素的数组
	 * @return		交换后的数组
	 */
	public int[] swapVarXOR(int[] num) {
        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];
        return num;
    }
	
	public static void main(String[] args) {
		out.println(getGreater(5, 9));
		out.println(getGreater(-5, -9));
		out.println(getGreater(-5, 3));
		out.println(getGreater(0, -3));
		out.println(getGreater(-3, 0));
		out.println(getGreater(0, 0));
		out.println(pow(2,2));
		out.println(findOddTimesNum(new int[]{1,3,4,3,1}));
	}

}
