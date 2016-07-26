/**

3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

题目分析：
    1. 最短距离：两个整数的最短距离是0.这点对于这道题比较重要，别忽略。
    2. 这道题和3Sum几乎同出一辙，所以方便于解题，我们还是在开头要对数组进行排序，要么没法定位指
    针移动。
    3. 另外，这道题中用到了INT_MAX这个值，这个值和 INT_MIN是相对应的，在很多比较求最大值最小值
    的情况，经常用这两个变量。

*/
import java.util.*;
public class Solution {
    /**
     * 解题思路：
            这道题的解题方法和3Sum几乎相同，设定三个指针，固定两个，根据和的大小移动另外一个。属于这道题
            目自己的东西就是distance比较这块儿，建立一个tmp distance和min distance比较。
            时间复杂度分析：
            这道题目和3Sum几乎是一个思路，所以时间复杂度为O(n2)。
	   总结： 这道题的解决方法主要要注意以下几点：
			1. 首先要对数组进行排序。
			2. 0是两个数组间最小的距离。
     * */
    public int threeSumClosest(int[] nums, int target) {
        //invalid corner case check
        if(nums == null || nums.length < 3){
            return Integer.MIN_VALUE;
        }
        int ret = 0;
        //first we suspect the distance between the sum and the target is the largest num
        int distance = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++){
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int tmp_val = nums[i] + nums[j] + nums[k];
                int tmp_distance;
                if(tmp_val < target){
                    tmp_distance = target - tmp_val;
                    if(tmp_distance < distance){
                        distance = tmp_distance;
                        ret = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                }else if(tmp_val > target){
                    tmp_distance = tmp_val - target;
                    if(tmp_distance < distance){
                        distance = tmp_distance;
                        ret = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }else{////note: in this case, the sum is 0, 0 means the shortest distance fro
                    ret = nums[i] + nums[j] + nums[k];
                    return ret;
                }
            }
        }
        return ret;
        
    }
}