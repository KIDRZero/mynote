/*

Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that > each element appear only once
and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example, Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].*/
public class Solution {
    /**对于一个排好序的数组来说， A[N + 1] >= A[N]  ，我们仍然使用两个游标i和j来处理，
     * 假设现在i = j + 1，如果A[i] == A[j]，那么我们递增i，直到A[i] != A[j]，
     * 这时候我们再设置A[j + 1] =A[i]，同时递增i和j，重复上述过程直到遍历结束。*/
    public int removeDuplicates(int[] nums) {
        if(nums == null && nums.length == 0){
            return 0;
        }
        int j = 0;
        int len = nums.length;
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}