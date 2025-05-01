class Solution {
    int dp[][];

    private int minSum(int i, int j, int grid[][]) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            return -1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = minSum(i, j + 1, grid);
        int down = minSum(i + 1, j, grid);
        int min = 0;
        if(right != -1 && down != -1) min = Math.min(right, down);
        else if(right != -1) min = right;
        else if(down != -1) min = down;
        return dp[i][j] = grid[i][j] + min;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for (int arr[] : dp) Arrays.fill(arr, -1);

        return minSum(0, 0, grid);
    }
}