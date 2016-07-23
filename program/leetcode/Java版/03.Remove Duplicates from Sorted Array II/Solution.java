/*

Remove Duplicates from Sorted Array II


Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.*/
public class Solution {
    /** 我们需要用一个计数器来记录重复的次数，如果重复次数大于等于2，我们会按照01题的方式处理，
     *  如果不是重复元素了，我们将计数器清零。
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null && nums.length == 0){
            return 0;
        }
        int j = 0;
        int count = 0;
        int len = nums.length;
        for(int i = 1; i < len; i++){
            if(nums[i] == nums[j]){
                count++;
                if(count < 2){
                    nums[++j] = nums[i];
                }
            }else{
                nums[++j] = nums[i];
                count = 0;
            }
        }
        return j + 1;
        
    }
}