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
     * 题目分析：
            这道题和3Sum几乎同出一辙，只不过是要求四个数字的和，在时间复杂度上要比3Sum高一个数量级。
       
       对于两点要求的处理：
            1. 首先要对整个数组进行排序，这样得到的答案自然是排序好的.
            2. 对于重复答案的处理和3Sum是一摸一样的。
       
       解题思路： 
            同3Sum.

      时间复杂度分析：
            这道题的解法，我选择的是空间复杂度为1， 时间复杂度为O(n3).对于这样的问题，如果到了KSum(K>=5),
            我觉得可以用hash_map来牺牲空间复杂度换取好一些的时间复杂度.
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