package com.liuyong666.util;

public class digui {
	public static void main(String[] args) {
		System.out.println(new digui().reverse(123));
	}
	StringBuilder sb = new StringBuilder();
	public String reverse(int n){
		
		if(n / 10 == 0){
			sb.append(n);
			return sb.toString();
		}else{
			int k = n % 10;
			sb.append(k);
			return reverse(n / 10);
		}
	}

}
