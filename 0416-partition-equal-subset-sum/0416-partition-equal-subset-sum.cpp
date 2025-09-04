class Solution {
public:
    bool dfs(int idx, int sumSoFar, int halfSum, vector<int> &nums, vector<vector<int>>&dp){
        // if(idx < 0) return false;
        if(sumSoFar > halfSum) return false;
        if(idx == 0){
            return (sumSoFar == halfSum);
        }
        if(dp[idx][sumSoFar] != -1) return dp[idx][sumSoFar];

        bool notTake = dfs(idx-1, sumSoFar, halfSum, nums, dp);
        bool take = dfs(idx-1, sumSoFar + nums[idx], halfSum, nums, dp);
        return dp[idx][sumSoFar] = (notTake || take);
    }
    bool canPartition(vector<int>& nums) {
        //the first thing is to calculate the total sum of the array
        int total = 0;
        for(int item: nums) total += item;
        if(total%2 != 0) return false;
        int n = nums.size();

        //METHOD 1: memoization solution
        vector<vector<int>> dp(n, vector<int>(total/2+1, -1));
        return dfs(n-1, 0, total/2, nums, dp);
        //write recursion first
    }
};