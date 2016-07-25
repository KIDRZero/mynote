/**

Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


*/
public class Solution {
    /**
     * A和B都已经是排好序的数组，我们只需要从后往前比较就可以了。
     * 因为A有足够的空间容纳A + B，我们使用游标i指向m + n - 1，也就是最大数值存放的地方，
     * 从后往前遍历A，B，谁大就放到i这里，同时递减i。
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int merge_index = m + n - 1;
        int nums1_index = m - 1;
        int nums2_index = n - 1;
        while(nums1_index >= 0 && nums2_index >= 0){
            if(nums1[nums1_index] > nums2[nums2_index]){
                nums1[merge_index--] = nums1[nums1_index--];
            }else{
                nums1[merge_index--] = nums2[nums2_index--];
            }
        }
        while(nums1_index >= 0){
            nums1[merge_index--] = nums1[nums1_index--];
        }
        while(nums2_index >= 0){
            nums1[merge_index--] = nums2[nums2_index--];
        }
    }
}