package com.liuyong666.offer;

public class Offer08 {
	
	/*
	 * ��Ŀ����
	 * 		��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
	 * 		����һ���ǵݼ����е�һ����ת�������ת�������СԪ�ء�
	 * 		��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
	 */
	public int search(int[] array){
        //������Ϊ�ջ��߳���Ϊ0��ʱ�򷵻�0
        if(array == null || array.length <=0){
            return 0;
        }
        //���鲻Ϊ��������ĳ��ȴ���0
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while(array[low] >= array[high]){
            //����Ԫ��
            if(high - low == 1){
                return array[high];
            }
            //��������Ԫ��
            mid = (low + high)/2;
            //low��mid��highλ�õ�Ԫ�ض���ͬ
            if(array[low] == array[high] && array[mid] == array[high]){
                //˳�����
                return orderSearch(array,low,high);
            }
            //����м�λ�õ�ֵ����array[low]��ֵ��˵����Сֵ��a[mid]���ұ�
            if(array[mid] >= array[low]){
                low = mid;
            }else if(array[mid] <= array[high]){
                high = mid;
            }
        }
       return array[mid];
    }
    
    //˳�����
    private int orderSearch(int[] array, int low, int high) {
        int result = array[low];
        for(int i = low + 1; i <= high;i++){
            if(result > array[i]){
                result = array[i];
            }
        }
        return result;
    }
	

}
