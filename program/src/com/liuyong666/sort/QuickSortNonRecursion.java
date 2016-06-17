package com.liuyong666.sort;

import java.util.Stack;

import com.liuyong666.pat.Main18;

public class QuickSortNonRecursion {

	 public static void main(String[] args) {
//         QuickSortNonRecursion qsnr = new QuickSortNonRecursion();
//         int[] array = {0, 2, 11, 121, 18, 99, 3, 5, 101, 22, 9, 100};
//         qsnr.quicksort(array);
//          for (int i : array) {
//                System.out.print(i + "  ");
//          }
		 
//		 int[] a = {3,1,2,8,7,5,9,4,6,0};
//		 int[] temp = new int[10];
//		 int[] sortOnce ={1,3,2,8,5,7,4,9,0,6};
//		 boolean isMerge = false;
//		 Main18.mSort(a, 0, a.length - 1, temp, sortOnce, isMerge);
//		 for (int i : a) {
//    	   System.out.print(a[i] + "  ");
//       	 }
        }
                 
        public void quicksort(int[] array) {
            if (array == null || array.length == 1) return;
            //��ſ�ʼ���������
            Stack<Integer> s = new Stack<Integer>(); 
            //ѹջ       
            s.push(0); 
            s.push(array.length - 1); 
            //����ѭ����ʵ��
            while (!s.empty()) { 
                int right = s.pop(); 
                int left = s.pop(); 
                //����������С�ڵ������������˵��������
                if (right <= left) continue; 
                         
                int i = partition(array, left, right); 
                if (left < i - 1) {
                    s.push(left);
                    s.push(i - 1);
                } 
                if (i + 1 < right) {
                    s.push(i+1);
                    s.push(right);
                }
            } 
        }
        //�ҵ����ģ����н���
        public int partition (int[] data, int first, int end)
        {
            int temp;
            int i=first,j=end;
            if(first<end)
            {
                temp=data[i];
                //��i=j��ʱ����˵��ɨ�������
                while(i<j)
                {
                    //���ұ������ɨ���ҵ�һ��С��temp��Ԫ��
                    while(j>i&&data[j]>temp)j--;
                    if(i<j)
                    {
                        //����Ԫ�ظ�ֵ��temp
                        data[i]=data[j];
                        //��ֵ���Ӧ�ý�i+1ָ����һ�����
                        i++;
                    }
                           
                    //Ȼ���������ұ߿�ʼɨ�裬�ҵ�һ������temp��Ԫ��
                    while(i<j&&temp>data[i])i++;
                    if(i<j)
                    {
                        //����Ԫ�ظ�ֵ��temp
                        data[j]=data[i];
                        //��ֵ���Ӧ�ý�j-1ָ��ǰһ�����
                        j--;
                    }
                }
                //�������ݷ���iλ����
                data[i]=temp;
            }
            return i;
        }
}
