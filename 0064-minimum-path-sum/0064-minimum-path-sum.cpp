class Solution {
public:
    // int dfs(int i, int j, vector<vector<int>>& grid, vector<vector<int>>& dp){
    //     //memoization approach
    //     if(i == 0 && j == 0) return grid[i][j];
    //     if(i < 0 || j < 0) return INT_MAX;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int top = INT_MAX, left = INT_MAX;
    //     if(j > 0) left = dfs(i, j-1, grid, dp);
    //     if(i > 0) top = dfs(i-1, j, grid, dp);

    //     return dp[i][j] = grid[i][j] + min(left, top);
    // }
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int> (n, 0));
        //tabulation bottom up approach to reduce the recursion stack space
        dp[0][0] = grid[0][0];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) continue;
                int top = INT_MAX, left = INT_MAX;
                if(j > 0) left = dp[i][j-1];
                if(i > 0) top = dp[i-1][j];
                
                dp[i][j] = grid[i][j] + min(left, top);
            }
        }
        return dp[m-1][n-1];
        // return dfs(m-1, n-1, grid, dp);
    }
};