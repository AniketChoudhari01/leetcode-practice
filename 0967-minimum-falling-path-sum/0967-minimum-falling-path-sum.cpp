class Solution {
public:
    int maxi = 101;
    int dfs(int i, int j, vector<vector<int>>& matrix, vector<vector<int>> &dp){
        if(i < 0 || j < 0 || j >= matrix[0].size()) return INT_MAX;
        if(i == 0) return matrix[i][j];
        if(dp[i][j] != maxi) return dp[i][j];

        int up = dfs(i-1, j, matrix, dp);
        int diag1 = dfs(i-1, j-1, matrix, dp);
        int diag2 = dfs(i-1, j+1, matrix, dp);

        return dp[i][j] = matrix[i][j] + min(min(diag1, diag2), up);
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        int mini = INT_MAX;
        vector<vector<int>> dp(m, vector<int>(n, maxi));
        for(int j=0; j<n; j++){
            mini = min(mini, dfs(m-1, j, matrix, dp));
        }
        return mini;
    }
};