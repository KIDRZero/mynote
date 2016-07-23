/*

Remove Element


Given an array and a value, remove all instances of that > value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/
public class Solution {
    /**使用两个游标i，j，遍历数组，
     * 如果碰到了value，使用j记录位置，同时递增i，直到下一个非value出现，
     * 将此时i对应的值复制到j的位置上，增加j，重复上述过程直到遍历结束。
     * 这时候j就是新的数组长度。
     */
    public int removeElement(int[] nums, int val) {
        if(nums == null && nums.length == 0){
            return 0;
        }
        int j = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == val){
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }
}