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
        /**不同于上一题，这里我们仅仅需要得到的第k层的集合，但只能使用O(k)的空间。
         * 所以不能用前面二维数组的方式，只能使用一位数组滚动计算
         * 
         * 帕斯卡三角的计算公式是这样的，A[k][n] = A[k-1][n-1] + A[k-1][n]。
         * 
         * 为避免覆盖，从后往前计算
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