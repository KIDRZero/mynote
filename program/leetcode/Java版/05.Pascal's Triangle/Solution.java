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
     * Ҫ�õ�һ����˹�����ǣ�����ֻ��Ҫ�ҵ����ɼ��ɡ�
     *      ��k����k��Ԫ��
     *      ÿ���һ���Լ����һ��Ԫ��ֵΪ1
     *      ���ڵ�k��k > 2�����n��n > 1 && n < k����Ԫ��A[k][n]��A[k][n] = A[k-1][n-1] + A[k-1][n]
     * 
     * ### ע�⣺
     *      ʹ��ArrayListʱ�򣬾��ܹ��캯����ʼ����������
     *      �ײ㴴���˸ô�С�����飬����ʹ��size()����ʱ��
     *      ���ص���Ȼ�ǵ�ǰ��ӵ�List�е�Ԫ�ظ����������ǳ�ʼ�������Ĵ�С��
     *      ���Ҫ�ر�ע��
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
                //��ǰ�е�ǰλ�õ�ֵΪ��һ�д�λ�õ�ֵ����һ�д�λ��ǰһ������ֵ�ĺ�
                int val = last.get(j - 1) + last.get(j);
                cur.add(j,val);
            }
            last = cur;
            list.add(cur);
        }
        return list;
    }
}