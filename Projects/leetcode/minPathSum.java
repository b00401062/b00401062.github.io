package leetcode;

class LeetCode {
    public int minPathSum(int[][] grid) {
        int nrow = grid.length;
        int ncol = grid[0].length;
        int[][] dp = new int[nrow + 1][ncol + 1];
        for (int i = 2; i <= nrow; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 2; j <= ncol; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[nrow][ncol];
    }
}
