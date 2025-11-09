class Solution {
    // private int dfs(int idx, int boughtIdx, int k, int prices[], int dp[][][]){
    //     if(idx == prices.length || k == 0) return 0;
    //     if(dp[idx][boughtIdx][k] != -1) return dp[idx][boughtIdx][k];
    //     int profit = 0;
    //     //transaction will be only completed when sold the stock which we bought before:
    //     if(boughtIdx == 1){//time to sell
    //         profit = Math.max(prices[idx]+dfs(idx+1, 1-boughtIdx, k-1, prices, dp),
    //                         dfs(idx+1, boughtIdx, k, prices, dp));
    //     }else{//time to buy it
    //         profit = Math.max(-prices[idx]+dfs(idx+1, 1-boughtIdx, k, prices, dp),
    //                         dfs(idx+1, boughtIdx, k, prices, dp));
    //     }
    //     return dp[idx][boughtIdx][k] = profit;
    // }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int dp[][][] = new int[n][2][k+1];
        //TABULATION: TC:O(N*2*k), SC: O(N*2*k)+O(N);stack
        // for(int a[][]:dp){
        //     for(int b[]: a){
        //         Arrays.fill(b, -1);
        //     }
        // }
        // return dfs(0, 0, k, prices, dp);

        //MEMOIZATION: reduces stack space
        // int dp[][][] = new int[n+1][2][k+1];
        //base case fill with zero

        // for(int idx = n-1; idx >=0; idx--){
        //     for(int boughtIdx = 0; boughtIdx < 2; boughtIdx++){
        //         for(int transactions = 0; transactions < k; transactions++){
        //             int profit = 0;
        //             if(boughtIdx == 1){//time to sell
        //                 profit = Math.max(prices[idx]+dp[idx+1][1-boughtIdx][transactions+1], 
        //                                 dp[idx+1][boughtIdx][transactions]);
        //             }else{
        //                 profit = Math.max(-prices[idx]+dp[idx+1][1-boughtIdx][transactions],
        //                                 dp[idx+1][boughtIdx][transactions]);
        //             }
        //             dp[idx][boughtIdx][transactions] = profit;
        //         }
        //     }
        // }
        // return dp[0][0][0];

        //SPACE OPTIMIZATION:
        int ahead[][] = new int[2][k+1];
        int curr[][] = new int[2][k+1];

        for(int idx = n-1; idx >=0; idx--){
            for(int boughtIdx = 0; boughtIdx < 2; boughtIdx++){
                for(int transactions = 0; transactions < k; transactions++){
                    int profit = 0;
                    if(boughtIdx == 1){//time to sell
                        profit = Math.max(prices[idx]+ahead[1-boughtIdx][transactions+1], 
                                        ahead[boughtIdx][transactions]);
                    }else{
                        profit = Math.max(-prices[idx]+ahead[1-boughtIdx][transactions],
                                        ahead[boughtIdx][transactions]);
                    }
                    curr[boughtIdx][transactions] = profit;
                }
            }
            ahead = curr;
        }
        return ahead[0][0];
    }
}