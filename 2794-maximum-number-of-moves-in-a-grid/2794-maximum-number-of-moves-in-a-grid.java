class Solution {

    private int recursiveSearch(int grid[][], int i, int j, int dp[][]) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int top=0, right=0, diagonal=0;
        // top right
        if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i][j] < grid[i - 1][j + 1]) {
            top = 1 + recursiveSearch(grid, i - 1, j + 1, dp);
        }
        if (j + 1 < grid[0].length && grid[i][j] < grid[i][j + 1]) {
            right = 1 + recursiveSearch(grid, i, j + 1, dp);

        } // right
        if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i][j] < grid[i + 1][j + 1]) {
            diagonal = 1 + recursiveSearch(grid, i + 1, j + 1, dp);
        }

        int res = Math.max(top, Math.max(right, diagonal));
        dp[i][j]=res;
        return res;
    }

    public int maxMoves(int[][] grid) {
        // top=0;
        // right=0;
        // diagonal=0;
        int m = grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            int ans = recursiveSearch(grid, i, 0, dp);
            maxi = Math.max(maxi, ans);
        }

        return maxi;
    }
}