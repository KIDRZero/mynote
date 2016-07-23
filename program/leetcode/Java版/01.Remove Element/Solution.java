/*

Remove Element


Given an array and a value, remove all instances of that > value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/
public class Solution {
    /**ʹ�������α�i��j���������飬
     * ���������value��ʹ��j��¼λ�ã�ͬʱ����i��ֱ����һ����value���֣�
     * ����ʱi��Ӧ��ֵ���Ƶ�j��λ���ϣ�����j���ظ���������ֱ������������
     * ��ʱ��j�����µ����鳤�ȡ�
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