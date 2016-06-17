package com.liuyong666.util;
import static java.lang.System.*;
import static java.lang.Math.*;
public class Bit {
	/**
	 * ���ñȽ���������ϴ�ֵ
	 * @param a		����a
	 * @param b		����b
	 * @return		�����������ϴ��ֵ
	 */
	public static int getGreater(int a, int b){
		/* �����������ķ���λ */
		int flag = ((a - b) >> 31) & 0x01;
		return flag * b + (1 - flag) * a;
	}
	
	/**
	 * һ��������ֻ��һ�������������Σ���������ż���Σ��ҳ������
	 * @param a	����
	 * @return	ֻ���������ε���
	 */
	public static int findOddTimesNum(int[] a){
		
		int res = a[0];
		for(int i = 1; i < a.length; i++){
			res ^= a[i];
		}
		return res;
	}
	
	/**
	 * ��n��Ԫ����ɵ����飬n-2����������ż���Σ������������������Σ����������������,�����O(1)�Ŀռ临�Ӷȣ��ҳ���������
	 * @param a ����
	 * @return	���������ε�������
	 */
	public static int[] findOddTimesTwoNums(int[] arr){
		
        int res = arr[0];
        for(int i = 1; i < arr.length; i++){
            res ^= arr[i];
        }
        //�����������
        int save_res = res;
        
        //����a������x��y�����������Σ�����  res = x ^ y
        //��Ϊx��y��һ������x��y�ĵ�kλһ����һ��������res�ĵ�kλΪ1��Ѱ��k
        int k = 0;
        while((res & 0x01) != 1){
            res >>= 1;
            k++;
        }
        
        int _res = 0;
        //_res�������е�kλΪ1����Щ�����������
        for(int i = 0; i < arr.length; i++){
            if(((arr[i] >> k) & 0x01) == 1){
                _res ^= arr[i];
            }
        }
		
		//�����ɺ�_resΪx��y�е�һ������һ����Ϊ_res ^ save_res
		return new int[]{_res, _res ^ save_res};
	}
	
	/**
	 * �����κζ��������������������ֵ(�Ӽ�ʵ�֣�ȱ���ǿ������)
	 * @param num	ӵ������Ԫ�ص�����
	 * @return		�����������
	 */
	public int[] swapVarAdd(int[] num) {
        num[0] = num[0] + num[1];
        num[1] = num[0] - num[1];
        num[0] = num[0] - num[1];
        return num;
    }
	
	/**
	 * �����κζ��������������������ֵ(���ʵ��)
	 * @param num	ӵ������Ԫ�ص�����
	 * @return		�����������
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
