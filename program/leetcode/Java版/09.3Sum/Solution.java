/**

3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) 

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

题目翻译：
    给定一个整型数组num，找出这个数组中满足这个条件的所有数字： num[i]+num[j]+num[k] = 0. 并且所有
    的答案是要和其他不同的，也就是说两个相同的答案是不被接受的。
题目的两点要求：
    1. 每个答案组里面的三个数字是要从大到小排列起来的。
    2. 每个答案不可以和其他的答案相同。
题目分析：
    1. 每一个答案数组triplet中的元素是要求升序排列的。
    2. 不能包含重复的答案数组。

*/
import java.util.*;
public class Solution {
    /**
     * 
        解题思路：
            1. 根据第一点要求： 因为要求每个答案数组中的元素是升序排列的，所以在开头我们要对数组进行排
            序。
            2. 根据第二点要求： 因为不能包含重复的答案数组，所以我们要在代码里面做一切去掉重复的操作，对
            于数组，这样的操作是相同的。开始的想法是把所有满足条件的答案数组存起来，之后
            再用map进行处理，感觉那样太麻烦了，所以这次给出的答案是不需要额外空间的。
        时间复杂度分析：
            对于这道题，因为是要找三个元素，所以怎样都要O(n2)的时间复杂度，目前我没有想出来O(n)时间复杂度
            的解法。
            归根结底，其实这是two pointers的想法，定位其中两个指针，根据和的大小来移动另外一个。解题中所要
            注意的就是一些细节问题。
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> total_res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return total_res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++){
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                List<Integer> cur_res = new ArrayList<Integer>();
                if(nums[i] + nums[j] + nums[k] == 0){
                    cur_res.add(nums[i]);
                    cur_res.add(nums[j]);
                    cur_res.add(nums[k]);
                    total_res.add(cur_res);
                    j++;
                    k--;
                    //this two while loop is used to skip the duplication solution
                    while(j < k && nums[j - 1] == nums[j]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else if(nums[i] + nums[j] + nums[k] < 0){//if the sum is less than the target
                    j++;
                }else{
                    k--;
                }
            }
            //this while loop also is used to skip the duplication solution
            while(i < len - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return total_res;
    }
}