package com.liuyong666.offer;

public class Offer11 {
	/*
	 * ��ֵ�������η�
	 * 		����һ��double���͵ĸ�����base��int���͵�����exponent��
	 * 		��base��exponent�η���
	 * 		����ʹ�ÿ⺯���������Ǵ�������
	 * 
	 * ������
	 * 		1. exponet=0, ֵΪ0
	 * 		2. exponet>0, ��ָ���η�
	 * 		3. exponet<0, ��base��-exponet�η��ĵ���
	 * 		ע�⣺����ʱ����ĸ����Ϊ0����base=0����������Ҫע������������
	 * 		����ʵ�����£�ʱ�临�Ӷ���O(n)
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
