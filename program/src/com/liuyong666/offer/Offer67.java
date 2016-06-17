package com.liuyong666.offer;

public class Offer67 {
	/**
	 * 机器人的运动范围
	 * 题目描述：
	 * 		地上有一个m行和n列的方格。
	 * 		一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
	 * 		但是不能进入行坐标和列坐标的数位之和大于k的格子。
	 * 		 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
	 * 		但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
	 * 		请问该机器人能够达到多少个格子？
	 * 思路：
	 * 		回溯法
	 */
	
    public int movingCount(int threshold, int rows, int cols) {
        // 创建一个数组记录一个格子是否被访问
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int i,
            int j, boolean[][] visited) {
        int count = 0;
        // 异常处理
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

    // 用于计算每个坐标的数位之和
    private int numberIndexCount(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }	

}
