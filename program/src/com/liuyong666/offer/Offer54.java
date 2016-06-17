package com.liuyong666.offer;

public class Offer54 {
	/*
	 * 表示数值的字符串
	 * 题目描述
	 * 		请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
	 * 		例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
	 * 		但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
	 */
	public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
	
    public boolean isNumeric1(char[] str) {
    	if(str == null || str.length == 0){
            return false;
        }
        String s = new String(str);
        s = s.trim();
        if (s.length() == 0)
            return false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case '.':
                if (dotFlag || eFlag || ((i == 0 || !(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9'))
                        && (i == s.length() - 1 || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))))
                    return false;
                dotFlag = true;
                break;
            case '+':
            case '-':
                if ((i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) || (i == s.length() - 1
                        || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9' || s.charAt(i + 1) == '.')))
                    return false;
                break;
            case 'e':
            case 'E':
                if (eFlag || i == s.length() - 1 || i == 0)
                    return false;
                eFlag = true;
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                break;
            default:
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		String string = String.valueOf(null);
		System.out.println(string);
	}

}
