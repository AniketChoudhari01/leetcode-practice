class Solution {
using ll = long long;
public:
    // int dfs(int idx, int target, vector<int> &coins, vector<vector<int>> &dp){
    //     //BASE CASES
    //     if(target == 0) return 1;
    //     if(idx == 0){
    //         //then check if the coin leaves 0 as divisor
    //         return (target % coins[idx] == 0);
    //     }
    //     if(dp[idx][target] != -1) return dp[idx][target];

    //     int notTaken = dfs(idx-1, target, coins, dp);
    //     int taken = 0;
    //     if(coins[idx] <= target) taken = dfs(idx, target-coins[idx], coins, dp);

    //     return dp[idx][target] = taken + notTaken;
    // }
    int change(int amount, vector<int>& coins) {
        //we are having the infinite supply of coins and we have to find the number of combinations that make up that amount when taken we don't need to move index as we don't know when it will give optimal answer.
        int n = coins.size();
        vector<vector<ll>> dp(n, vector<ll>(amount+1, 0));
        for(int target = 0; target<= amount; target++){
            if(target%coins[0] == 0){
                dp[0][target] = 1;
            }else{
                dp[0][target] = 0;
            }
        }
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        for(int idx=1; idx<n; idx++){
            for(int target = 0; target<= amount; target++){
                int notTaken = dp[idx-1][target];
                int taken = 0;
                if(coins[idx] <= target) taken = dp[idx][target-coins[idx]];

                dp[idx][target] = ll(notTaken) + ll(taken);
            }
        }
        return dp[n-1][amount];
    }
};