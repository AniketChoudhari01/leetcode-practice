class Solution {
public:
    // int dfs(int i, int j, int m, int n, vector<vector<int>> &dp){//top down
    // approach
    //     if(i < 0 || j < 0 ) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(i == 0 && j == 0) return 1;

    //     int left = dfs(i, j-1, m, n, dp);
    //     int top = dfs(i-1, j, m , n, dp);

    //     return dp[i][j] = left + top;
    // }
    int uniquePaths(int m, int n) {
        // bottom up approach
        //  vector<vector<int>> dp(m+1, vector<int>(n+1, -1));
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = 1;
        // memoization to tabulation solution(bottom up)
        // 1: Declare base cases
        // 2: Express all states in for loop
        // 3: Loop the recurrence and write
        //  for(int i=0; i<m; i++){
        //      for(int j=0; j<n; j++){
        //          if(i == 0 && j == 0) continue;

        //         int left = 0, top = 0;
        //         if(j>0) left = dp[i][j-1];
        //         if(i>0) top = dp[i-1][j];
        //         dp[i][j] = left + top;
        //     }
        // }
        //space optimization technique:
        vector<int> prev(n,0);
        for (int i = 0; i < m; i++) {
            vector<int> curr(n, 0);
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    curr[j] = 1;
                    continue;
                }else{
                    int left = 0, top = 0;
                    if(j>0) top = curr[j-1];
                    if(i> 0) left = prev[j];
                    curr[j] = top + left;
                }
            }
            prev = curr;
        }

        // return dfs(m-1, n-1, m, n, dp);
        return prev[n-1];
    }
};