class Solution {
public:
    int dfs(int idx, int target, vector<int> &nums, vector<vector<int>> &dp){
        //BASE CASE
        if(idx == 0){
            if(nums[0] == 0 && target == 0) return 2;
            if(nums[0] == target || target == 0) return 1;
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int notTaken = dfs(idx-1, target, nums, dp);
        int taken = 0;
        if(nums[idx] <= target) taken = dfs(idx-1, target-nums[idx], nums, dp);
        return dp[idx][target] = taken + notTaken;
    }
    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        int total = 0;
        for(auto &it: nums) total += it;
        int D = target;

        if((total+target)%2 != 0 || total < abs(target)) return 0;//when sum is odd then not possible

        vector<vector<int>> dp(n, vector<int>(total+1, -1));

        int s1 = (total + target)/2;
        return dfs(n-1, s1, nums, dp);
    }
};