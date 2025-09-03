class Solution {
public:
    // int dfs(int i, int j, vector<vector<int>>& matrix, vector<vector<int>> &dp){
    //     if(i < 0 || j < 0 || j >= matrix[0].size()) return INT_MAX;
    //     if(i == 0) return matrix[i][j];
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int up = dfs(i-1, j, matrix, dp);
    //     int diag1 = dfs(i-1, j-1, matrix, dp);
    //     int diag2 = dfs(i-1, j+1, matrix, dp);

    //     return dp[i][j] = matrix[i][j] + min(min(diag1, diag2), up);
    // }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        int mini = INT_MAX;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }
        //top down approach we build our answer from the base case
            for(int i = 1; i<m; i++){
                for(int j=0; j<n; j++){

                    int up = dp[i-1][j];
                    int diag1 = (j > 0) ? dp[i-1][j-1] : INT_MAX;
                    int diag2 = (j < n-1) ? dp[i-1][j+1] : INT_MAX;
                    
                    dp[i][j] = matrix[i][j] + min({diag1, diag2, up});
                }
            }
        // for(auto &item: dp){
        //     for(int it: item){
        //         cout<<it<<" ";
        //     }
        //     cout<<"\n";
        // }
        for(int i=0; i<n; i++) mini = min(mini, dp[m-1][i]);

        return mini;
    }
};