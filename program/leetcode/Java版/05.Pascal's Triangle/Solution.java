/**
Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
public class Solution {
    /**
     * 要得到一个帕斯卡三角，我们只需要找到规律即可。
     *      第k层有k个元素
     *      每层第一个以及最后一个元素值为1
     *      对于第k（k > 2）层第n（n > 1 && n < k）个元素A[k][n]，A[k][n] = A[k-1][n-1] + A[k-1][n]
     * 
     * ### 注意：
     *      使用ArrayList时候，尽管构造函数初始化了容量，
     *      底层创建了该大小的数组，但是使用size()函数时，
     *      返回的仍然是当前添加到List中的元素个数，而不是初始化容量的大小，
     *      这点要特别注意
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows <= 0){
            return list;
        }
        List<Integer> cur = null;
        List<Integer> last = null; 
        for(int i = 0; i < numRows; i++){
            cur = new ArrayList<Integer>(i + 1);
            cur.add(1);
            
            if(i > 0){
                cur.add(cur.size() - 1, 1);
            }
            for(int j = 1; j < i; j++){
                //当前行当前位置的值为上一行此位置的值与上一行此位置前一个数的值的和
                int val = last.get(j - 1) + last.get(j);
                cur.add(j,val);
            }
            last = cur;
            list.add(cur);
        }
        return list;
    }
}