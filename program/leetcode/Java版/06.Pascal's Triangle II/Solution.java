/*

Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        /**��ͬ����һ�⣬�������ǽ�����Ҫ�õ��ĵ�k��ļ��ϣ���ֻ��ʹ��O(k)�Ŀռ䡣
         * ���Բ�����ǰ���ά����ķ�ʽ��ֻ��ʹ��һλ�����������
         * 
         * ��˹�����ǵļ��㹫ʽ�������ģ�A[k][n] = A[k-1][n-1] + A[k-1][n]��
         * 
         * Ϊ���⸲�ǣ��Ӻ���ǰ����
         * */
         List<Integer> res = new ArrayList<Integer>(rowIndex + 1);
         for(int i = 0; i <= rowIndex; i++){
             res.add(1);
         }
         for(int i = 0; i < rowIndex + 1; i++){
             for(int j = i - 1; j >= 1; j--){
                 int val = res.get(j) + res.get(j - 1);
                 res.set(j, val);
             }
         }
         return res;
    }
}