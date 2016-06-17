package com.liuyong666.offer;

public class Offer66 {
	/**
	 * �����е�·��
	 * ��Ŀ������
	 * 		�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
	 * 		·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
	 * 		���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� 
	 * 		���� 		a b c e
	 * 			 	s f c s 
	 * 				a d e e 
	 * 		�����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
	 * 		��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
	 * ˼·��
	 * 		���ݷ���
	 * 		��ν���ݷ����ǰ�ѡ��������ǰ�������ԴﵽĿ�ꡣ
	 * 		����̽����ĳһ��ʱ������ԭ��ѡ�񲢲��Ż�ﲻ��Ŀ�꣬���˻�һ������ѡ��
	 * 		���嵽�����Ŀ���Ƕ���ÿ���ַ�������ھ������ҵ������ھ����е�λ�ã�
	 * 		������һ��Ѱ�ҵ�ʱ�򣬿��Դ��ϡ��¡������ĸ����򣨱߽�Ԫ�س��⣩���еݹ�Ѱ�ң�����ҵ��������Ѱ����һ���ַ���
	 * 		���û���ҵ��Ļ�����ص���һ���ַ�����Ѱ�ҡ�ֱ���ҵ�ȫ���ַ��ھ����ж�Ӧ��λ�á�
	 * 
	 */
	/*
	 *  ����˼·�Ǵ���һ���������飬���ڼ�¼�������Ѿ����ʹ��ı�ǡ� 
	 *  ����·���еĵ�i���ַ������˱߽��Ԫ���⣬
	 *  ����λ�õ�Ԫ�ض����ϡ��¡������ĸ����ڵ�λ�á�
	 *  ��ô·���еĵ�i+1���ַ��� �Դ����ĸ�λ����Ѱ�ҵõ������˽��еݹ飬ֱ���ҵ����һ���ַ� �ھ����е�λ��Ϊֹ��
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
	    // ����һ����������
	    boolean[] visited = new boolean[matrix.length];
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            if (hasPathCore(matrix, rows, cols, i, j, 0, str, visited)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	private boolean hasPathCore(char[] matrix, int rows, int cols, int i,
	        int j, int k, char[] str, boolean[] visited) {
		
	    // ���ڸ��������������õ����ھ����е��±�
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k]
		        || visited[index])
		    return false;
		visited[index] = true;
		// ����ݹ鵽���һ��λ�õ��ַ��������ǰ��λ�õ��ַ����ھ������ҵ��˶�Ӧ��λ��
		if (k == str.length - 1)
		    return true;
		// ���û�еݹ鵽���һ��λ�õ��ַ���������ݹ�,k+1��ʾ�����ھ�����Ѱ��str��������һ��λ�õ��ַ��ھ����е�λ��
		if (hasPathCore(matrix, rows, cols, i - 1, j, k + 1, str, visited)
		        || hasPathCore(matrix, rows, cols, i + 1, j, k + 1, str, visited)
		        || hasPathCore(matrix, rows, cols, i, j - 1, k + 1, str, visited)
		        || hasPathCore(matrix, rows, cols, i, j + 1, k + 1, str, visited)) {
		    return true;
		}else{
		    //������ڸ��ӵ��ַ���û��ƥ�䵽��һ���ַ�������Ҫ�ص�ǰһ�����ӣ��Ӷ���Ҫ�Ѱ�λ�õ�״̬�����趨Ϊδ����
		        k--;
		        visited[index] = false;
		}
		return false;
	}
}
