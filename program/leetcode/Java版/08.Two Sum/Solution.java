/**

Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

The return format had been changed to zero-based indices. Please read the above updated description carefully.

*/
import java.util.*;
public class Solution {
    /**
     * 暴力法时间复杂度高，使用哈希表可以降低
     * 
     * 
     * 我们可以先把这个数组的所有元素存到hashmap中，一次循环就行， 时间复杂度为O(n),
     * 之后对所给数组在进行遍历，针对其中的元素我们只要用another_number = target-numbers[i],
     * 之后用hashmap的find function来查找这个值，如果存在的话，在进行后续比较（详见代码）
     * ，如果不存在的话，继续查找。
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] no_found = new int[]{-1, -1};
        if(nums == null || nums.length <= 1){
            return no_found;
        }
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < len; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < len; i++){
            int another_number = target - nums[i];
            if(map.containsKey(another_number)){
                int index = map.get(another_number);
                if(index == i){//如果是同一个数字，我们就pass，是不会取这个值的
                    continue;
                }
                return new int[]{i, index};
            }
        }
        return no_found;
    }
}