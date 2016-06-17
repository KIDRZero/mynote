package com.liuyong666.offer;

public class Offer11 {
	/*
	 * 数值的整数次方
	 * 		给定一个double类型的浮点数base和int类型的整数exponent。
	 * 		求base的exponent次方。
	 * 		不得使用库函数，不考虑大数问题
	 * 
	 * 分析：
	 * 		1. exponet=0, 值为0
	 * 		2. exponet>0, 求指数次方
	 * 		3. exponet<0, 求base的-exponet次方的倒数
	 * 		注意：求倒数时，分母不能为0，即base=0的情况，因此要注意该特殊情况。
	 * 		代码实现如下：时间复杂度是O(n)
	 */
    public double power(double base, int exponent) {
        
    	//base = 0,exponent < 0
    	if(equal(base, 0.0) && exponent < 0){
    		return 0.0;
    	}
    	
    	//exponent < 0
    	int absExponent = exponent;
    	if(exponent < 0){
    		absExponent = -exponent;
    	}
    	
    	double result = powerAbsExponent(base, absExponent);
    	
    	if(exponent < 0){
    		result = 1.0 / result;
    	}
    	
    	return result;
    }
    
    private double powerAbsExponent(double base, int absExponent) {
		double result = 1.0;
    	for(int i = 0; i < absExponent; i++){
			result *= base;
		}
		return result;
	}

	private boolean equal(double num1, double num2){
    	if(num1 - num2 < 0.0000001 && num1 - num2 > -0.0000001){
    		return true;
    	}
    	return false;
    }
	
	public static void main(String[] args) {
		System.out.println(new Offer11().power(0.5, -2));
	}

}
