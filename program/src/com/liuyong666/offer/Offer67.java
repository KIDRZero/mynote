package com.liuyong666.offer;

public class Offer67 {
	/**
	 * �����˵��˶���Χ
	 * ��Ŀ������
	 * 		������һ��m�к�n�еķ���
	 * 		һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
	 * 		���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
	 * 		 ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
	 * 		���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
	 * 		���ʸû������ܹ��ﵽ���ٸ����ӣ�
	 * ˼·��
	 * 		���ݷ�
	 */
	
    public int movingCount(int threshold, int rows, int cols) {
        // ����һ�������¼һ�������Ƿ񱻷���
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int i,
            int j, boolean[][] visited) {
        int count = 0;
        // �쳣����
        if (i < 0 || i >= rows || j < 0 || j >= cols
                || numberIndexCount(i) + numberIndexCount(j) > threshold
                || visited[i][j])
            return 0;
        visited[i][j] = true;
        count = 1 + movingCountCore(threshold, rows, cols, i - 1, j, visited)
                  + movingCountCore(threshold, rows, cols, i + 1, j, visited)
                  + movingCountCore(threshold, rows, cols, i, j - 1, visited)
                  + movingCountCore(threshold, rows, cols, i, j + 1, visited);
        return count;
    }

    // ���ڼ���ÿ���������λ֮��
    private int numberIndexCount(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }	

}
