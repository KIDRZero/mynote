package com.liuyong666.sort;

import java.util.Arrays;
import java.util.Random;

import com.liuyong666.sort.MySort;

public class MySortTest {
	public static void main(String[] args) {
		int[] a = new int[1000000];
		Random r = new Random(10000000);
		for(int i = 0;i<1000000;i++){
			a[i] = r.nextInt(10000000);
		}
		long start,end;
		
		int[] b = Arrays.copyOf(a, a.length);
		
		start = System.currentTimeMillis();
		MySort.selectSort(a);
		end = System.currentTimeMillis();
		System.out.println("ѡ��"+(end-start));
		
		int[] c = Arrays.copyOf(b, b.length);
		start = System.currentTimeMillis();
		MySort.insertSort(b);
		end = System.currentTimeMillis();
		System.out.println("���룺"+(end-start));
		
		int[] d = Arrays.copyOf(c, c.length);

		start = System.currentTimeMillis();
		MySort.quickSortNonRecursion(c);
		end = System.currentTimeMillis();
		System.out.println("���ŷǵݹ飺"+(end-start));
		
		int[] e = Arrays.copyOf(d, d.length);

		start = System.currentTimeMillis();
		MySort.quickSort(d);
		end = System.currentTimeMillis();
		System.out.println("���ŵݹ飺"+(end-start));
		
		int[] f = Arrays.copyOf(e, e.length);
		
		start = System.currentTimeMillis();
		MySort.mergeSort(e);
		end = System.currentTimeMillis();
		System.out.println("�鲢��"+(end-start));
		
		int[] g = Arrays.copyOf(f, f.length);
		
		start = System.currentTimeMillis();
		MySort.radixSort(f, 10000000);
		end = System.currentTimeMillis();
		System.out.println("������"+(end-start));
		
		int[] h = Arrays.copyOf(g, g.length);
		
		start = System.currentTimeMillis();
		MySort.shellSort(g);
		end = System.currentTimeMillis();
		System.out.println("ϣ����"+(end-start));
		
		int[] x = Arrays.copyOf(h, h.length);
		
		start = System.currentTimeMillis();
		MySort.heapSort(h);
		end = System.currentTimeMillis();
		System.out.println("���ţ�"+(end-start));
		
		start = System.currentTimeMillis();
		MySort.bubbleSort(x);
		end = System.currentTimeMillis();
		System.out.println("ð�ݣ�"+(end-start));
		
		
		
		
//		int b[]={5,4,9,8,7,6,0,1,3,2};
//		int[] c=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
//		MySort.shellSort(b);
//		for(int i = 0;i < b.length;i++){
//			System.out.print(b[i]+" ");
//		}
		
//		System.out.println();
////		MySort.radixSort(b, 10);
//		MySort.insertSort(c);
//		for(int i = 0;i < c.length;i++){
//			System.out.print(c[i]+" ");
//		}
//		
		
	}

}
