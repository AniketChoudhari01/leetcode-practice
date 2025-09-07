class Solution {
public:
    const int INF = 1e9; // avoid overflows as less than INT_MAX
    long long dfs(int idx, int amount, vector<int>&coins, vector<vector<int>> &dp){
        //when the amount is achieved return 0
        if(amount == 0) return 0;
        if(idx == 0){
            if(amount%coins[idx] != 0){
                return INF;
            }else{
                return (amount/coins[0]);
            }
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        long long notTaken = dfs(idx-1, amount, coins, dp);
        long long taken = INT_MAX;
        if(coins[idx] <= amount){
            //here the thing is I have to think of all possible no. of times I should taken coins[idx]
            //not greedily selecting all the division possible as (amount/coins[idx]);
            // long long achieved = (amount/coins[idx]);//gives number of coins for this time
            taken = 1 + dfs(idx, amount - coins[idx], coins, dp);
        }
        // cout<<min(taken,notTaken)<<"\n";
        return dp[idx][amount] = min(taken, notTaken);
    }
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int>(amount+1, -1));
        int ans = dfs(n-1, amount, coins, dp);
        return ans >= INF? -1: ans;
    }
};