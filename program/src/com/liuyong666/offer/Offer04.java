package com.liuyong666.offer;

public class Offer04 {
	
	/**
	 * ��Ŀ����
	 * 		��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
	 * 		���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
	 */
    public String replaceSpace(StringBuffer str) {
    	String s = str.toString();
    	//ͳ�ƿո���
    	int blank_count = getBlankNum(s);
    	//��ȡԭ�����ַ�������
    	int oldStrLen = s.toCharArray().length;
    	//�����滻�ո����Ҫ�ĳ���
    	int newStrLen = oldStrLen + blank_count * 2;
    	char[] newArray = new char[newStrLen];
    	//��ԭ���ַ������Ƶ�newArray������
    	System.arraycopy(s.toCharArray(), 0, newArray, 0, oldStrLen);
    	int oldStrIndex = oldStrLen - 1;
    	int newStrIndex = newStrLen - 1;
    	//��oldStrIndex == newStrIndexʱ�滻���
    	while(oldStrIndex >= 0 && oldStrIndex != newStrIndex){
    		if(newArray[oldStrIndex] == ' '){
    			newArray[newStrIndex--] = '0';
    			newArray[newStrIndex--] = '2';
    			newArray[newStrIndex--] = '%';
    		}else{
    			newArray[newStrIndex--] = newArray[oldStrIndex];
    		}
    		oldStrIndex--;
    	}
    	return new String(newArray);
    }

	private int getBlankNum(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				count++;
			}
		}
		return count;
	}
}
