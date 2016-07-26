/**

3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

��Ŀ������
    1. ��̾��룺������������̾�����0.�����������Ƚ���Ҫ������ԡ�
    2. ������3Sum����ͬ��һ�ޣ����Է����ڽ��⣬���ǻ����ڿ�ͷҪ�������������Ҫôû����λָ
    ���ƶ���
    3. ���⣬��������õ���INT_MAX���ֵ�����ֵ�� INT_MIN�����Ӧ�ģ��ںܶ�Ƚ������ֵ��Сֵ
    �������������������������

*/
import java.util.*;
public class Solution {
    /**
     * ����˼·��
            �����Ľ��ⷽ����3Sum������ͬ���趨����ָ�룬�̶����������ݺ͵Ĵ�С�ƶ�����һ�������������
            Ŀ�Լ��Ķ�������distance�Ƚ�����������һ��tmp distance��min distance�Ƚϡ�
            ʱ�临�Ӷȷ�����
            �����Ŀ��3Sum������һ��˼·������ʱ�临�Ӷ�ΪO(n2)��
	   �ܽ᣺ �����Ľ��������ҪҪע�����¼��㣺
			1. ����Ҫ�������������
			2. 0�������������С�ľ��롣
     * */
    public int threeSumClosest(int[] nums, int target) {
        //invalid corner case check
        if(nums == null || nums.length < 3){
            return Integer.MIN_VALUE;
        }
        int ret = 0;
        //first we suspect the distance between the sum and the target is the largest num
        int distance = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++){
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int tmp_val = nums[i] + nums[j] + nums[k];
                int tmp_distance;
                if(tmp_val < target){
                    tmp_distance = target - tmp_val;
                    if(tmp_distance < distance){
                        distance = tmp_distance;
                        ret = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                }else if(tmp_val > target){
                    tmp_distance = tmp_val - target;
                    if(tmp_distance < distance){
                        distance = tmp_distance;
                        ret = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }else{////note: in this case, the sum is 0, 0 means the shortest distance fro
                    ret = nums[i] + nums[j] + nums[k];
                    return ret;
                }
            }
        }
        return ret;
        
    }
}