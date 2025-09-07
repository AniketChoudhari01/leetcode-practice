class Solution {
public:
    const int INF = 1e9; // avoid overflows as less than INT_MAX
    // long long dfs(int idx, int amount, vector<int>& coins,
    //               vector<vector<int>>& dp) {
    //     // when the amount is achieved return 0
    //     if (amount == 0)
    //         return 0;
    //     if (idx == 0) {
    //         if (amount % coins[idx] != 0) {
    //             return INF;
    //         } else {
    //             return (amount / coins[0]);
    //         }
    //     }
    //     if (dp[idx][amount] != -1)
    //         return dp[idx][amount];

    //     long long notTaken = dfs(idx - 1, amount, coins, dp);
    //     long long taken = INT_MAX;
    //     if (coins[idx] <= amount) {
    //         // here the thing is I have to think of all possible no. of times I
    //         // should taken coins[idx] not greedily selecting all the division
    //         // possible as (amount/coins[idx]);
    //         //  long long achieved = (amount/coins[idx]);//gives number of coins
    //         //  for this time
    //         taken = 1 + dfs(idx, amount - coins[idx], coins, dp);
    //     }
    //     // cout<<min(taken,notTaken)<<"\n";
    //     return dp[idx][amount] = min(taken, notTaken);
    // }
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        // vector<vector<int>> dp(n, vector<int>(amount + 1, 0));
        // int ans = dfs(n - 1, amount, coins, dp);
        // return ans >= INF ? -1 : ans;

        // tabulation
        // for (int tar = 0; tar <= amount; tar++) {
        //     if (tar%coins[0] == 0) {//when I can completely achieve the current target from the 0th idx
        //         dp[0][tar] = tar / coins[0];
        //     }else{
        //         dp[0][tar] = 1e9;
        //     }
        // }
        // for(int idx=1; idx<n; idx++){
        //     for(int target = 0; target<= amount; target++){
        //         int notTaken = dp[idx-1][target];
        //         int taken = INT_MAX;
        //         if(coins[idx] <= target) taken = 1 + dp[idx][target-coins[idx]];
        //         dp[idx][target] = min(taken, notTaken);
        //     }
        // }
        // if(dp[n-1][amount] >= 1e9 ) return -1;
        // return dp[n-1][amount];

        // SPACE OPTIMIZATION
        vector<int> prev(amount+1, 0), curr(amount+1, 0);
        for(int tar = 0; tar<=amount; tar++){
            if(tar%coins[0] == 0){
                prev[tar] = tar/coins[0];
            }else{
                prev[tar] = 1e9;
            }
        }
        for(int idx=1; idx<n;idx++){
            for(int tar = 0; tar<= amount; tar++){
                int notTaken = prev[tar];
                int taken = INT_MAX;
                if(coins[idx] <= tar) taken = 1+curr[tar-coins[idx]];
                curr[tar] = min(taken, notTaken);
            }
            prev = curr;
        }
        return( prev[amount] >= 1e9) ? -1: prev[amount];
    }
};