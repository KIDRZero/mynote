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
	 * 调整数组顺序使奇数位于偶数前面
	 * 保证奇数和奇数，偶数和偶数之间的相对位置不变
	 */
	//遍历每个元素，一旦发现偶数就取出来，让它之后的元素向前移动，把取出来的元素补到最后的空位上
	//类似插入排序，具体实现是外循环找奇数，内循环将该数之前的偶数移位
	public static void reOrderArray(int array[]){
		
		if(array == null || array.length == 0){
			return;
		}
		
		for(int i = 1; i < array.length; i++){
			int current = array[i];
			if(!isEven(current)){		//找到奇数位置
				int j = i - 1;			//从奇数前一个位置开始
				for(; j >= 0 && isEven(array[j]); j--){	//发现偶数就移位
					array[j + 1] = array[j];
				}
				array[j + 1] = current;		//把奇数插入到偶数前面
			}
		}
	}
	/*
	 * 调整数组顺序使奇数位于偶数前面
	 * 相对位置可以改变时，更为高效解法
	 */
	//维护两个指针，一首一尾，首指针向后遍历，检测到偶数时暂停，尾指针向前遍历，检测到奇数时暂停，交换首尾两个数。继续这样的判断，知道首尾指针相遇。
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
	
	
	//判断一个数是否是偶数
	public static boolean isEven(int i){
		
		return (i & 0x1) == 0;
	}

}
