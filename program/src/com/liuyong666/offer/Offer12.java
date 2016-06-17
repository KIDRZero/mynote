package com.liuyong666.offer;

public class Offer12 {
	
	/*
	 * 打印1到最大的n位数
	 * 题目描述：
	 * 		输入数字n，按顺序打印出从1最大的n位十进制数。
	 * 		比如输入3，则打印出1、2、3一直到最大的3位数即999.
	 */
	  
    /** 
     * 思路：
     * 1.使用字符串存放数字。int a=123 --> char[] a={'1','2','3'}; 
     * 2.递归。设置好第n位（最高位，对应char数组的第0个元素）后，接下来设置第n-1,n-2.....位 
     * 3.打印时候，前面的0不输出，见printNumber(char[] number) 
     */  
    public static void main(String[] args) {  
        int n=5;  
        Offer12 p=new Offer12 ();  
        p.print(n);  
    }  
  
    public void print(int n){  
        char[] result = new char[n];  
        printHelpRecursive(result, n, 0);  
    }  
      
    //from result[0] to result[n-1],set 0-9 into it  
    public void printHelpRecursive(char[] result,int length,int index){  
        if(index == length){  
            printNumber(result);  
        }else{  
            for(int i = 0; i <= 9; i++){  
                result[index] = (char)('0' + i);  
                printHelpRecursive(result, length, index + 1);  
            }  
        }  
    }  
      
    //don't print the prefix '0'.e.g,when "0012",print "12"  
    public void printNumber(char[] re){  
        int len = re.length;  
        boolean canPrint = false;  
        for(int i = 0; i < len - 1; i++){  
            if(!canPrint && re[i] != '0'){  
                canPrint = true;  
            }  
            if(canPrint){  
                System.out.print(re[i]);  
            }  
        }  
        System.out.println(re[len-1]);//the last bit is always printed.  
    } 
}
