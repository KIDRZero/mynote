package com.liuyong666.offer;

public class Offer14 {
	public static void main(String[] args) {
		System.out.println(isEven(2)+" "+isEven(3));
		int a[] = {1,2,4,5,2,6,7};
		for(int x:a){
			System.out.print(x+" ");
		}
		System.out.println();
		reOrderArray2(a);
		for(int x:a){
			System.out.print(x+" ");
		}
	}
	/*
	 * ��������˳��ʹ����λ��ż��ǰ��
	 * ��֤������������ż����ż��֮������λ�ò���
	 */
	//����ÿ��Ԫ�أ�һ������ż����ȡ����������֮���Ԫ����ǰ�ƶ�����ȡ������Ԫ�ز������Ŀ�λ��
	//���Ʋ������򣬾���ʵ������ѭ������������ѭ��������֮ǰ��ż����λ
	public static void reOrderArray(int array[]){
		
		if(array == null || array.length == 0){
			return;
		}
		
		for(int i = 1; i < array.length; i++){
			int current = array[i];
			if(!isEven(current)){		//�ҵ�����λ��
				int j = i - 1;			//������ǰһ��λ�ÿ�ʼ
				for(; j >= 0 && isEven(array[j]); j--){	//����ż������λ
					array[j + 1] = array[j];
				}
				array[j + 1] = current;		//���������뵽ż��ǰ��
			}
		}
	}
	/*
	 * ��������˳��ʹ����λ��ż��ǰ��
	 * ���λ�ÿ��Ըı�ʱ����Ϊ��Ч�ⷨ
	 */
	//ά������ָ�룬һ��һβ����ָ������������⵽ż��ʱ��ͣ��βָ����ǰ��������⵽����ʱ��ͣ��������β�������������������жϣ�֪����βָ��������
	public static void reOrderArray2(int array[]){
		
		int low = 0;
		int high = array.length - 1;
		while(low < high){
			while(low < high && !isEven(array[low])){
				low++;
			}
			while(low < high && isEven(array[high])){
				high--;
			}
			if(low < high){
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
			
			
		}
		
	}
	
	
	//�ж�һ�����Ƿ���ż��
	public static boolean isEven(int i){
		
		return (i & 0x1) == 0;
	}

}
