package com.liuyong666.offer;

public class Offer36 {
	/*
	 * �����е������
	 * ��Ŀ������
	 * 		�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
	 * 		����һ�����飬�����������е�����Ե�������
	 * ˼·��
	 * 		�ֶ���֮��˼��
	 * 		�ݹ�طֽ�ɳ���Ϊ1���������
	 * 		�ϲ����򣬲�ͳ�������
	 * 		���ù鲢�����˼·
	 */
    public int inversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }
        
        return mergerCount(array, copy, 0, array.length - 1);
        
    }
    private int mergerCount(int[] array, int[] copy, int start, int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int len = (end - start) / 2;
        int leftCount = mergerCount(copy, array, start, start + len);
        int rightCount = mergerCount(copy, array, start + len + 1, end);
        //iָ���һ����������һ���±꣬jָ��ڶ�����������һ���±�
        int i = start + len;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + len + 1){
            if(array[i] > array[j]){
                copy[indexCopy--] = array[i--];
                count += j - start - len;
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(; i >= start; i--){
			copy[indexCopy--] = array[i];
        }
        for(; j >= start + len + 1; j--){
            copy[indexCopy--] = array[j];
        }
        
        return count + leftCount + rightCount;
    }
    
    public static void main(String[] args) {
		int x = new Offer36().inversePairs(new int[]{1,2,3,4,7,6,5});
		System.out.println(x);
	}
	

}
