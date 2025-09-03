class Solution {
public:
    int dfs(int i, int j1, int j2, int m, int n, vector<vector<int>>& grid, vector<vector<vector<int>>>&dp){
        //BASE CASES
        //1. out of bound edge case
        if(j1 < 0 || j1 >= n || j2 < 0 || j2 >= n){
            return -1e9;
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        //2. destination base case
        if(i == m-1){
            if(j1 == j2){
                //if they end up in same cell
                return grid[i][j1];
            }else{
                //they are at different col
                return grid[i][j1] + grid[i][j2];
            }
        }

        //STEP 2: Explore all possible paths
        int dj[3] = {-1, 0, 1};
        //for every possible r1 positions r2 has 3 directions to visit so
        int maxi = 0;
        for(int dj1: dj){
            for(int dj2: dj){
                int value = 0;
                //STEP 3: Do stuffs on path
                if(j1 == j2){
                    //when intersects in a cell we have to consider only once
                    value = grid[i][j1];
                }else{
                    value = grid[i][j1] + grid[i][j2];
                }
                value += dfs(i+1, j1+dj1, j2+dj2, m, n, grid, dp);
                maxi = max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    int cherryPickup(vector<vector<int>>& grid) {
        //step1: write recursion soln
        int m = grid.size(), n = grid[0].size();
        //step2: dp memoization solution
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(n, -1)));
        //initial pos of r1 and r2
        return dfs(0, 0, n-1,m, n, grid, dp);
    }
};