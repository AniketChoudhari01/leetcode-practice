class Solution {
public:
    // bool dfs(int idx, int sumSoFar, int halfSum, vector<int> &nums, vector<vector<int>>&dp){
    //     // if(idx < 0) return false;
    //     if(sumSoFar > halfSum) return false;
    //     if(idx == 0){
    //         return (sumSoFar == halfSum);
    //     }
    //     if(dp[idx][sumSoFar] != -1) return dp[idx][sumSoFar];

    //     bool notTake = dfs(idx-1, sumSoFar, halfSum, nums, dp);
    //     bool take = dfs(idx-1, sumSoFar + nums[idx], halfSum, nums, dp);
    //     return dp[idx][sumSoFar] = (notTake || take);
    // }
    bool canPartition(vector<int>& nums) {
        //the first thing is to calculate the total sum of the array
        int total = 0;
        for(int item: nums) total += item;
        if(total%2 != 0) return false;
        int n = nums.size();

        //METHOD 1: memoization solution
        // vector<vector<int>> dp(n, vector<int>(total/2+1, -1));
        // return dfs(n-1, 0, total/2, nums, dp);
        //write recursion first

        //METHOD 2: Tabulation same question as target sum (k) can you find a subset in the array
        int target = total/2;
        vector<vector<bool>> dp(n, vector<bool>(target+1, false));
        //BASE CASE 
        //sum = 0 is always achievable at any case whether you pick or not pick
        for(int i = 0; i<n; i++){ //NxTarget
            dp[i][0] = true;
        }
        //other base case is if idx == 0 return (a[0] == target) only for this case it is true
        //here one more case comes let us take we have n=1, nums[0] = 10 and target = 3
        //here we have to make a check for it as well then only mark it positive
        if(nums[0] <= target) dp[0][nums[0]] = true; 

        for(int idx = 1; idx < n; idx++){
            for(int sumSoFar=1; sumSoFar <= target; sumSoFar++){
                bool notTake = dp[idx-1][sumSoFar];
                bool take = false;
                //only take the current element when it's value is less than or equal to the target
                if(nums[idx] <= sumSoFar) take = dp[idx-1][sumSoFar-nums[idx]];
                dp[idx][sumSoFar] = (notTake || take);
            }
        }
        return dp[n-1][target];
    }
};