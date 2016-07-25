/**

3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c) 

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

��Ŀ���룺
    ����һ����������num���ҳ������������������������������֣� num[i]+num[j]+num[k] = 0. ��������
    �Ĵ���Ҫ��������ͬ�ģ�Ҳ����˵������ͬ�Ĵ��ǲ������ܵġ�
��Ŀ������Ҫ��
    1. ÿ���������������������Ҫ�Ӵ�С���������ġ�
    2. ÿ���𰸲����Ժ������Ĵ���ͬ��
��Ŀ������
    1. ÿһ��������triplet�е�Ԫ����Ҫ���������еġ�
    2. ���ܰ����ظ��Ĵ����顣

*/
import java.util.*;
public class Solution {
    /**
     * 
        ����˼·��
            1. ���ݵ�һ��Ҫ�� ��ΪҪ��ÿ���������е�Ԫ�����������еģ������ڿ�ͷ����Ҫ�����������
            ��
            2. ���ݵڶ���Ҫ�� ��Ϊ���ܰ����ظ��Ĵ����飬��������Ҫ�ڴ���������һ��ȥ���ظ��Ĳ�������
            �����飬�����Ĳ�������ͬ�ġ���ʼ���뷨�ǰ��������������Ĵ������������֮��
            ����map���д����о�����̫�鷳�ˣ�������θ����Ĵ��ǲ���Ҫ����ռ�ġ�
        ʱ�临�Ӷȷ�����
            ��������⣬��Ϊ��Ҫ������Ԫ�أ�����������ҪO(n2)��ʱ�临�Ӷȣ�Ŀǰ��û�������O(n)ʱ�临�Ӷ�
            �Ľⷨ��
            �����ף���ʵ����two pointers���뷨����λ��������ָ�룬���ݺ͵Ĵ�С���ƶ�����һ������������Ҫ
            ע��ľ���һЩϸ�����⡣
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> total_res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return total_res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++){
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                List<Integer> cur_res = new ArrayList<Integer>();
                if(nums[i] + nums[j] + nums[k] == 0){
                    cur_res.add(nums[i]);
                    cur_res.add(nums[j]);
                    cur_res.add(nums[k]);
                    total_res.add(cur_res);
                    j++;
                    k--;
                    //this two while loop is used to skip the duplication solution
                    while(j < k && nums[j - 1] == nums[j]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else if(nums[i] + nums[j] + nums[k] < 0){//if the sum is less than the target
                    j++;
                }else{
                    k--;
                }
            }
            //this while loop also is used to skip the duplication solution
            while(i < len - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return total_res;
    }
}