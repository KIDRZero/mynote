/**

Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


*/
public class Solution {
    /**
     * A��B���Ѿ����ź�������飬����ֻ��Ҫ�Ӻ���ǰ�ȽϾͿ����ˡ�
     * ��ΪA���㹻�Ŀռ�����A + B������ʹ���α�iָ��m + n - 1��Ҳ���������ֵ��ŵĵط���
     * �Ӻ���ǰ����A��B��˭��ͷŵ�i���ͬʱ�ݼ�i��
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