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
            //存放开始与结束索引
            Stack<Integer> s = new Stack<Integer>(); 
            //压栈       
            s.push(0); 
            s.push(array.length - 1); 
            //利用循环里实现
            while (!s.empty()) { 
                int right = s.pop(); 
                int left = s.pop(); 
                //如果最大索引小于等于左边索引，说明结束了
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
        //找到轴心，进行交换
        public int partition (int[] data, int first, int end)
        {
            int temp;
            int i=first,j=end;
            if(first<end)
            {
                temp=data[i];
                //当i=j的时候，则说明扫描完成了
                while(i<j)
                {
                    //从右边向左边扫描找到一个小于temp的元素
                    while(j>i&&data[j]>temp)j--;
                    if(i<j)
                    {
                        //将该元素赋值给temp
                        data[i]=data[j];
                        //赋值后就应该将i+1指向下一个序号
                        i++;
                    }
                           
                    //然后从左边向右边开始扫描，找到一个大于temp的元素
                    while(i<j&&temp>data[i])i++;
                    if(i<j)
                    {
                        //将该元素赋值给temp
                        data[j]=data[i];
                        //赋值后就应该将j-1指向前一个序号
                        j--;
                    }
                }
                //将轴数据放在i位置中
                data[i]=temp;
            }
            return i;
        }
}
