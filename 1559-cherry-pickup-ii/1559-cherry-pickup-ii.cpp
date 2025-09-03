class Solution {
public:
    // M1: memoization approach tc = 3^N*3^N*9 for each r1 and r2 there are 3
    // ways to travel and sc = O(M*N*N) grid space
    //  int dfs(int i, int j1, int j2, int m, int n, vector<vector<int>>& grid,
    //  vector<vector<vector<int>>>&dp){
    //      //BASE CASES
    //      //1. out of bound edge case
    //      if(j1 < 0 || j1 >= n || j2 < 0 || j2 >= n){
    //          return -1e9;
    //      }

    //     if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

    //     //2. destination base case
    //     if(i == m-1){
    //         if(j1 == j2){
    //             //if they end up in same cell
    //             return grid[i][j1];
    //         }else{
    //             //they are at different col
    //             return grid[i][j1] + grid[i][j2];
    //         }
    //     }

    //     //STEP 2: Explore all possible paths
    //     int dj[3] = {-1, 0, 1};
    //     //for every possible r1 positions r2 has 3 directions to visit so
    //     int maxi = 0;
    //     for(int dj1: dj){
    //         for(int dj2: dj){
    //             int value = 0;
    //             //STEP 3: Do stuffs on path
    //             if(j1 == j2){
    //                 //when intersects in a cell we have to consider only once
    //                 value = grid[i][j1];
    //             }else{
    //                 value = grid[i][j1] + grid[i][j2];
    //             }
    //             value += dfs(i+1, j1+dj1, j2+dj2, m, n, grid, dp);
    //             maxi = max(maxi, value);
    //         }
    //     }
    //     return dp[i][j1][j2] = maxi;
    // }
    // int cherryPickup(vector<vector<int>>& grid) {
    //     //step1: write recursion soln
    //     int m = grid.size(), n = grid[0].size();
    //     //step2: dp memoization solution
    //     vector<vector<vector<int>>> dp(m, vector<vector<int>>(n,
    //     vector<int>(n, -1)));
    //     //initial pos of r1 and r2
    //     return dfs(0, 0, n-1,m, n, grid, dp);
    // }

    // M2: tabulation
    int cherryPickup(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<vector<int>>> dp(
            m, vector<vector<int>>(n, vector<int>(n, 0)));
        // from base case build up answer first row we have to see from
        // memoization soln we have to loop
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2)
                    dp[m-1][j1][j2] = grid[m-1][j1];
                else
                    dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
            }
        }

        // jitne number of states rahenge in dfs utne loop lagana
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int maxi = INT_MIN;
                    // step 2: explore all possible paths for both robots r1, r2
                    int dj[3] = {-1, 0, 1};
                    for (int dj1 : dj) {
                        for (int dj2 : dj) {
                            int value = 0;
                            if (j1 == j2) {
                                // when they reach at the same cell return one
                                // time of that cell value
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }

                            // simulate like recursion call
                            if (j1 + dj1 >= 0 && j1 + dj1 < n &&
                                j2 + dj2 >= 0 && j2 + dj2 < n) {
                                value += dp[i+1][j1 + dj1][j2 + dj2];//res from next row
                            } else {
                                value = -1e9;
                            }
                            maxi = max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        // comes to base case where r1 at (0, 0) and r2 at (0, n-1)
        return dp[0][0][n - 1];
    }
};