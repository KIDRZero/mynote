package com.liuyong666.offer;

public class Offer01 {

	/**
	 * ʵ��Singletonģʽ
	 * 
	 * 		�̰߳�ȫ�Ķ��Գ�ʼ��
	 * 		
	 */
    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null)
            resource = new Resource();
        return resource;
    }
    static class Resource {
    }
}
