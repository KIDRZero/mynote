package com.liuyong666.offer;

public class Offer12 {
	
	/*
	 * ��ӡ1������nλ��
	 * ��Ŀ������
	 * 		��������n����˳���ӡ����1����nλʮ��������
	 * 		��������3�����ӡ��1��2��3һֱ������3λ����999.
	 */
	  
    /** 
     * ˼·��
     * 1.ʹ���ַ���������֡�int a=123 --> char[] a={'1','2','3'}; 
     * 2.�ݹ顣���úõ�nλ�����λ����Ӧchar����ĵ�0��Ԫ�أ��󣬽��������õ�n-1,n-2.....λ 
     * 3.��ӡʱ��ǰ���0���������printNumber(char[] number) 
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
