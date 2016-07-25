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
     * ������ʱ�临�Ӷȸߣ�ʹ�ù�ϣ����Խ���
     * 
     * 
     * ���ǿ����Ȱ�������������Ԫ�ش浽hashmap�У�һ��ѭ�����У� ʱ�临�Ӷ�ΪO(n),
     * ֮������������ڽ��б�����������е�Ԫ������ֻҪ��another_number = target-numbers[i],
     * ֮����hashmap��find function���������ֵ��������ڵĻ����ڽ��к����Ƚϣ�������룩
     * ����������ڵĻ����������ҡ�
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
                if(index == i){//�����ͬһ�����֣����Ǿ�pass���ǲ���ȡ���ֵ��
                    continue;
                }
                return new int[]{i, index};
            }
        }
        return no_found;
    }
}