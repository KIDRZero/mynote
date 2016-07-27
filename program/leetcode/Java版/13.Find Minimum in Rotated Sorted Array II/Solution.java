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
     * 这题跟上题唯一的区别在于元素可能有重复，我们仍然采用上面的方法，
     * 只是需要处理mid与start相等这种额外情况。
        A[mid] > A[start]，右半区间查找。
        A[mid] < A[start]，左半区间查找。
        A[mid] = A[start]，出现这种情况，我们跳过start，重新查找，
        譬如[2,2,2,1]，A[mid] = A[start]都为2，
        这时候我们跳过start，使用[2,2,1]继续查找。
        
        注意:
            如果重复元素很多，那么最终会退化到遍历整个数组，而不是二分查找了。
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