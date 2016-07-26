/**

4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: 
    The solution set must not contain duplicate quadruplets.
    Elements in quadruplets (a, b, c, d) must be in non-descending order. (ie, a<=b<=c<=d)

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


*/
import java.util.*;
public class Solution {
    /**
     * ��Ŀ������
            ������3Sum����ͬ��һ�ޣ�ֻ������Ҫ���ĸ����ֵĺͣ���ʱ�临�Ӷ���Ҫ��3Sum��һ����������
       
       ��������Ҫ��Ĵ���
            1. ����Ҫ����������������������õ��Ĵ���Ȼ������õ�.
            2. �����ظ��𰸵Ĵ����3Sum��һ��һ���ġ�
       
       ����˼·�� 
            ͬ3Sum.

      ʱ�临�Ӷȷ�����
            �����Ľⷨ����ѡ����ǿռ临�Ӷ�Ϊ1�� ʱ�临�Ӷ�ΪO(n3).�������������⣬�������KSum(K>=5),
            �Ҿ��ÿ�����hash_map�������ռ临�ӶȻ�ȡ��һЩ��ʱ�临�Ӷ�.
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> total_res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return total_res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){
            //this if is used to skip the duplication solution
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < len - 2; j++){
                //this if is used to skip the duplication solution
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int m = j + 1;
                int n = len - 1;
                while(m < n){
                    List<Integer> cur_res = new ArrayList<Integer>();
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if(sum == target){
                        cur_res.add(nums[i]);
                        cur_res.add(nums[j]);
                        cur_res.add(nums[m]);
                        cur_res.add(nums[n]);
                        total_res.add(cur_res);
                        m++;
                        n--;
                        //this two while loop is used to skip the duplication solution
                        while(m < n && nums[m - 1] == nums[m]){
                            m++;
                        }
                        while(m < n && nums[n + 1] == nums[n]){
                            n--;
                        }
                    }else if(sum < target){
                        m++;
                    }else{
                        n--;
                    }
                }
            }
        }
        return total_res;
    }
}