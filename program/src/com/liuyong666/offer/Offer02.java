package com.liuyong666.offer;

public class Offer02 {

	/**
	 * 实现Singleton模式
	 * 		最佳方式
	 */
    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    public static Resource getResource() {
        return Offer02.ResourceHolder.resource;
    }
    
    static class Resource{
    	
    }
}

