class Solution {
public:
    // int dfs(int i, int j, vector<vector<int>>& obstacleGrid, vector<vector<int>> dp){
    //     if(i < 0 || j< 0) return 0;
    //     if(obstacleGrid[i][j] == 1) return 0;//it is obstacle
    //     if(i == 0 && j == 0) return 1;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     //go left
    //     int left = 0, top = 0;
    //     left = dfs(i, j-1, obstacleGrid, dp);
    //     top = dfs(i-1, j, obstacleGrid, dp);
    //     return dp[i][j] = left + top;
    // }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        vector<vector<int>> dp(m, vector<int> (n, 0));
        // return dfs(m-1, n-1, obstacleGrid, dp);
        //moving towards tabulation method bottom up approach
        dp[0][0] = 1;
        for(int i=0; i<m ;i++){
            for(int j = 0; j<n; j++){
                if(i == 0 && j == 0) continue;
                int left = 0, top = 0;
                if(j > 0 && obstacleGrid[i][j-1] != 1) left = dp[i][j-1];
                if(i > 0 && obstacleGrid[i-1][j] != 1) top = dp[i-1][j];
                dp[i][j] = left + top;
            }
        }
        return dp[m-1][n-1];
    }
};