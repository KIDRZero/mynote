package com.liuyong666.sort;

import java.util.Stack;

public class MySort {
	
	/*
	 * ð������
	 * ����Ԫ�رȽϣ����Ԫ�������
	 */
	public static void bubbleSort(int array[]){
		
		for(int i = array.length - 1 ; i >= 0 ; i--){
			
			boolean flag = false;//����һ�������Ƿ��н����ı�ʶ
			
			for(int j = 0 ; j < i ; j++){//һ��ð������
				
				if(array[j] > array[j+1]){
					swap(array, j, j+1);
					flag = true;//��ʶ�����˽���
				}
			}
			
			if(!flag)
				break;
		}
	}
	
	/*
	 * ѡ������
	 * ÿ��λ��ѡ��ǰԪ����С��
	 */
	public static void selectSort(int array[]){
		
		
		for(int i = 0 ; i < array.length-1 ; i++){
			
			int minPosition = i;
			int min = array[i];
			
			for(int j = i+1 ; j <array.length ; j++){
				
				if(array[j] < min){
					min = array[j];
					minPosition = j;
				}
				
			}
			//��i���ǵ�ǰԪ����С�ģ�����ҵ����Ǹ�Ԫ�ؽ���
			if(i !=  minPosition){
				array[minPosition] = array[i];
				array[i] = min;
			}
		}
	}
	
	/*
	 * ��������
	 * �Ѿ������С���еĻ����ϣ�һ�β���һ��Ԫ��
	 */
	public static void insertSort(int array[]){
		
		for(int i = 1 ; i < array.length ; i++){
			
			int current = array[i];//����Ԫ��
			
			int j = i;
			for(; j > 0 && array[j - 1] > current ; j--){//��ǰɨ�裬ֻҪ���ִ���Ԫ�رȽ�С���Ͳ���
				
				array[j] = array[j - 1];//�Ƴ���λ
				
			}
			
			array[j] = current;//Ԫ�ز���
		}
	}
	
	/*
	 * ��������
	 * ����������ߵ�i�±�һֱ�����ߣ���a[i] <= a[center_index]��
	 * ����center_index������Ԫ�ص������±꣬һ��ȡΪ�����0��Ԫ�ء����ұߵ�j�±�һֱ�����ߣ���a[j] > a[center_index]
	 * ���i��j���߲����ˣ�i <= j, ����a[i]��a[j],�ظ�����Ĺ��̣�ֱ��i>j
	 * ����a[j]��a[center_index]�����һ�˿�������
	 * �����������ȡ�з������Ż�
	 */
	//�ݹ��������
	public static void quickSort(int a[]){
		qSort(a, 0, a.length - 1);
	}
	//�ǵݹ���������ֶ�����ջ���洢ÿ�ηֿ���ŵ���ʼ�㣬ջ�ǿ�ʱѭ����ȡ������ջ  
	public static void quickSortNonRecursion(int array[]){
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
	//�ݹ�����������·����
	public static void qSort(int a[],int low,int high){
		int pivot = 0;
		if(low < high){
			//������һ��Ϊ��
			pivot = partition(a,low,high);
			//�Ե�һ���ֽ��еݹ�����
			qSort(a,low,pivot);
			//�Եڶ����ֽ��еݹ�����
			qSort(a,pivot + 1,high);
		}
	}
	
	public static int partition(int a[],int low,int high){
		
		int pivotkey = a[low];//ѡȡ��һ��Ԫ��Ϊ�����¼
		while(low < high){
			//���������¼С�Ľ������Ͷ�
			while(low < high && a[high] >= pivotkey){
				high--;
			}
			//�����滻�����ǽ����ķ�ʽ����
            a[low] = a[high];
			//���������¼��Ľ������߶�
			while(low < high && a[low] <= pivotkey){
				low++;
			}
			a[high] = a[low];
		}
		//��Ŧ����λ�ø�ֵ
		a[low] = pivotkey;
		//������Ŧ���ڵ�λ��
		return low;
	}
	
	/*
	 * �鲢����
	 * �����еݹ�طֳɶ�����
	 * �ݹ�����Ƕ�����ֻ��1��Ԫ��(��Ϊֱ������)����2������(1�αȽϺͽ���),
	 * Ȼ��Ѹ�������Ķ����кϲ���һ������ĳ����У����Ϻϲ�ֱ��ԭ����ȫ���ź���
	 */
	//���ж�����������a[first...mid]��a[mid+1...last]�ϲ���  
	public static void merge(int a[], int first, int mid, int last, int temp[]){
		
		int i = first,j = mid+1;
		int k = 0;
		
		while(i <= mid && j<= last){
			if(a[i]<a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		
		while(i <= mid)
			temp[k++] = a[i++];
		while(j <= last)
			temp[k++] = a[j++];
		
		for(i = 0 ; i < k ; i++)
			a[first+i] = temp[i];
	}
	
	//�ݹ�ϲ�����
	public static void mSort(int a[], int first,int last, int temp[]){
		if(first < last){
			int mid = (first + last) / 2;
			mSort(a, first, mid, temp);
			mSort(a, mid+1, last, temp);
			merge(a, first, mid, last, temp);
			
		}
	}
	//�ṩͨ�ù鲢����ӿ�
	public static void mergeSort(int a[]){
		int[] temp = new int[a.length];
		mSort(a, 0, a.length-1, temp);
	}
	
	public static void swap(int array[],int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/*
	 * ϣ������
	 * ���ղ�ͬ������Ԫ�ؽ��в�������
	 * ���������һ��
	 */
	public static void shellSort(int a[]){
		//����һ���������У����ָ����������
		int inc = a.length,i,j,temp;
		do{
			inc = inc / 3 + 1;
			for(i = inc ; i < a.length ; i++){
				if(a[i] < a[i - inc]){
					//��a[i]�������������
					temp = a[i];
					//��¼����
					for(j = i - inc ; j >= 0 && temp < a[j] ; j -= inc){
						a[j + inc] = a[j];
					}
					//����Ҫ�����ֵ���뵽�Ǹ�λ�ã�������j+inc
					a[j + inc] = temp;
				}
			}
		}while(inc > 1);//ѭ������ֹ������������Ϊ1��ʱ��
	}
	
	/*
	 * ������
	 * �������ѣ�������Ԫ�غ����һ��Ԫ�ء�
	 * ����˵����
	 *     a -- �����������
	 */
	public static void heapSort(int[] a) {
		int n = a.length;
		int i,tmp;

		// ��(n/2-1) --> 0��α���������֮�󣬵õ�������ʵ������һ��(���)����ѡ�
		for (i = n / 2 - 1; i >= 0; i--)
			maxHeapDown(a, i, n-1);

		// �����һ��Ԫ�ؿ�ʼ�����н��е��������ϵ���С�����ķ�Χֱ����һ��Ԫ��
		for (i = n - 1; i > 0; i--) {
			// ����a[0]��a[i]��������a[i]��a[0...i]�����ġ�
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			// ����a[0...i-1]��ʹ��a[0...i-1]��Ȼ��һ�����ѡ�
			// ������֤a[i-1]��a[0...i-1]�е����ֵ��
			maxHeapDown(a, 0, i-1);
		}
	}
	/*
	 * ע������ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
	 *     ���У�NΪ�����±�����ֵ���������е�1������Ӧ��NΪ0��
	 *
	 * ����˵����
	 *     a -- �����������
	 *     start -- ���µ��ڵ����ʼλ��(һ��Ϊ0����ʾ�ӵ�1����ʼ)
	 *     end   -- ������Χ(һ��Ϊ���������һ��Ԫ�ص�����)
	 */
	public static void maxHeapDown(int[] a, int start, int end) {
		int c = start;			// ��ǰ(current)�ڵ��λ��
		int l = 2*c + 1;		// ��(left)���ӵ�λ��
		int tmp = a[c];			// ��ǰ(current)�ڵ�Ĵ�С

		for (; l <= end; c=l,l=2*l+1) {
			// "l"�����ӣ�"l+1"���Һ���
			if ( l < end && a[l] < a[l+1])
				l++;		// ������������ѡ��ϴ��ߣ���m_heap[l+1]
			if (tmp >= a[l])
				break;		// ��������
			else {			// ����ֵ
				a[c] = a[l];
				a[l]= tmp;
			}
		}
	}
	
	/*
	 * ��������
	 * ���յ�λ������Ȼ���ռ����ٰ��ո�λ����Ȼ�����ռ����������ƣ�ֱ�����λ
	 */
	public  static void radixSort(int[] array,int d)
	{
	    int n=1;//����λ����Ӧ������1,10,100...
	    int k=0;//����ÿһλ�����Ľ��������һλ����������
	    int length=array.length;
	    int[][] bucket=new int[10][length];//����Ͱ���ڱ���ÿ�������Ľ������һλ����������ͬ�����ַ���ͬһ��Ͱ��
	    int[] order=new int[length];//���ڱ���ÿ��Ͱ���ж��ٸ�����
	    while(n<d)
	    {
	        for(int num:array) //������array���ÿ�����ַ�����Ӧ��Ͱ��
	        {
	            int digit=(num/n)%10;
	            bucket[digit][order[digit]]=num;
	            order[digit]++;
	        }
	        for(int i=0;i<length;i++)//��ǰһ��ѭ�����ɵ�Ͱ������ݸ��ǵ�ԭ���������ڱ�����һλ��������
	        {
	            if(order[i]!=0)//���Ͱ�������ݣ����ϵ��±������Ͱ�������ݱ��浽ԭ������
	            {
	                for(int j=0;j<order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;
	                }
	            }
	            order[i]=0;//��Ͱ���������0��������һ��λ����
	        }
	        n*=10;
	        k=0;//��k��0��������һ�ֱ���λ������
	    }
	    
	}

	
	

}
