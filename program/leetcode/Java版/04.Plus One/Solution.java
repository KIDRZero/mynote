/*

Plus One  

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/
public class Solution {
    /**
     * ģ��ӷ����㣬��λ�ӵ���һλ��������
     * ע�����λ�����Ľ�λ����Ҫ��������
     */
    public int[] plusOne(int[] digits) {
        if(digits == null && digits.length == 0){
            return null;
        }
        int len = digits.length;
        int[] res = new int[len];
        int sum = 0;
        int one = 1;
        for(int i = len - 1; i >= 0; i--){
            sum = one + digits[i];
            one = sum / 10;
            res[i] = sum % 10;
        }
        
        if(one > 0){
            int[] res_ext = new int[len + 1];
            res_ext[0] = one;
            for(int i = 0, k = 1; i < len; i++, k++){
                res_ext[k] = res[i];
            }
            return res_ext;
        }
        return res;
        
    }
}