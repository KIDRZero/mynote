package com.liuyong666.offer;

public class Offer01 {

	/**
	 * 实现Singleton模式
	 * 
	 * 		线程安全的惰性初始化
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
