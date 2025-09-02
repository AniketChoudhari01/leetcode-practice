class Solution {
public:
    // int dfs(int row,int col,int m, vector<vector<int>>& triangle,
    // vector<vector<int>> dp){
    //     if(row >= m) return 0;
    //     int n = triangle[row].size();
    //     if(col >= n) return 0;
    //     if(row == m-1 && col == n-1) return triangle[row][col];
    //     if(dp[row][col] != -1) return dp[row][col];

    //     int sameCol = dfs(row+1, col, m, triangle, dp);
    //     int nextCol = dfs(row+1, col+1, m, triangle, dp);

    //     return dp[row][col] = triangle[row][col] + min(sameCol, nextCol);
    // }
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size();
        // vector<vector<int>> dp(m, vector<int> (m, -1));
        // return dfs(0, 0, m, triangle, dp);
        // vector<vector<int>> dp(m, vector<int> (m, 0) );
        // for (int j = 0; j < triangle[m - 1].size(); j++) {
        //     dp[m - 1][j] = triangle[m - 1][j];
        // }
        // dp[0][0] = triangle[0][0];
        // for(int i = m-2; i>=0; i--){
        //     int n = triangle[i].size();
        //     for(int j=0; j<n; j++){
        //         int sameCol = dp[i+1][j];
        //         int nextCol = dp[i+1][j+1];
        //         dp[i][j] = triangle[i][j] + min(sameCol, nextCol);
        //     }
        // }
        // return dp[0][0];

        // space optimized dp
        vector<int> prev(m, 0);
        for(int j = 0; j < triangle[m-1].size(); j++){
            prev[j] = triangle[m-1][j];
        }

        for(int i= m-2; i>=0; i--){
            int n = triangle[i].size();
            vector<int> temp(n, 0);
            for(int j=0; j<n; j++){
                int sameCol = prev[j];
                // int nextCol = 0;
                int nextCol = prev[j+1];
                temp[j] = triangle[i][j] + min(sameCol, nextCol);
            }
            prev = temp;
        }
        return prev[0];
    }
};