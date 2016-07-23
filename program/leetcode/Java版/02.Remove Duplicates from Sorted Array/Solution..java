/*

Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that > each element appear only once
and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example, Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].*/
public class Solution {
    /**����һ���ź����������˵�� A[N + 1] >= A[N]  ��������Ȼʹ�������α�i��j������
     * ��������i = j + 1�����A[i] == A[j]����ô���ǵ���i��ֱ��A[i] != A[j]��
     * ��ʱ������������A[j + 1] =A[i]��ͬʱ����i��j���ظ���������ֱ������������*/
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