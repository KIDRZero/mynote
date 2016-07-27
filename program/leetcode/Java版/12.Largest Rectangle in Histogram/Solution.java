/**

Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

For example,
Given heights = [2,1,5,6,2,3],
return 10.


*/

import java.util.*;
public class Solution {
    /**
     * �����Ŀ���ǱȽ��ѵ�һ����Ŀ�ˣ�������򵥵��������Ƕ�������һ��bar���������ұ�����
     * ֱ���߶�С�ڸ�bar����ʱ����������ľ������������
     * ����ÿһ��bar�����Ƕ������ϴ������Ϳ��Եõ����ֵ�ˡ�
     * ��Ȼ����������O(n2)�����������˴����ݼ��ϲ��Եġ�
     * 
     * 
        ����������ֱ������������һ��bar n�����ǵõ��İ�����bar n�ľ�����������bar n����С�ġ�����ʹ��ln
        ��rn����ʾbar n�����Լ����ҵ�һ��С��bar n��bar������λ�á�
        
        Ʃ����Ŀ�е�bar 2�ĸ߶�Ϊ5������lnΪ1��rnΪ4������bar 2�ľ����������Ϊ(4 - 1 - 1) * 5 = 10��
        
        ���ǿ��Դ����ұ�������bar��������push��һ��stack�У������ǰbar�ĸ߶�С��ջ��bar������pop��
        ջ����bar��ͬʱ�Ը�bar��������������ô�������֪����bar��ln��rn�أ�rn�������ǵ�ǰ��������bar
        ����������ln���ǵ�ǰ��ջ��bar����������Ϊ��ʱջ��bar�ĸ߶�һ��С��pop������bar�ĸ߶ȡ�
        Ϊ�˸��õĴ������һ��bar�������������ʵ���л����һ���߶�Ϊ0��bar����������pop�����һ��bar
        �������ˡ�
     * 
     * */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        int len = heights.length;
        for(int i = 0; i < len; i++){
            list.add(heights[i]);
        }
        list.add(0);
        Stack<Integer> s = new Stack<Integer>();
        
        int sum = 0;
        int i = 0;
        while(i < list.size()){
            if(s.empty() || list.get(i) > list.get(s.peek())){
                s.push(i);
                i++;
            }else{
                int t = s.peek();
                s.pop();
                //���ﻹ��Ҫ����stackΪ�յ����
                sum = Math.max(sum, list.get(t) * (s.empty() ? i : i - s.peek() - 1));
            }
        }
        return sum;
        
    }
}