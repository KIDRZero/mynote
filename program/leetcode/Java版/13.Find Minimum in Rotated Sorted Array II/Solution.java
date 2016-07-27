/**

Find Minimum in Rotated Sorted Array II

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.


*/
public class Solution {
    /**
     * ���������Ψһ����������Ԫ�ؿ������ظ���������Ȼ��������ķ�����
     * ֻ����Ҫ����mid��start������ֶ��������
        A[mid] > A[start]���Ұ�������ҡ�
        A[mid] < A[start]�����������ҡ�
        A[mid] = A[start]�����������������������start�����²��ң�
        Ʃ��[2,2,2,1]��A[mid] = A[start]��Ϊ2��
        ��ʱ����������start��ʹ��[2,2,1]�������ҡ�
        
        ע��:
            ����ظ�Ԫ�غܶ࣬��ô���ջ��˻��������������飬�����Ƕ��ֲ����ˡ�
    */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return Integer.MAX_VALUE;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }else if(len ==2){
            Math.min(nums[0],nums[1]);
        }
        int lo = 0;
        int hi = len - 1;
        while(lo < hi - 1){
            if(nums[lo] < nums[hi]) {
                return nums[lo];
            }  
            
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[lo]){
                lo = mid;
            }else if(nums[mid] < nums[lo]){
                hi = mid;
            }else{
                lo++;
            }
        }
        return Math.min(nums[lo],nums[hi]);        
    }
}