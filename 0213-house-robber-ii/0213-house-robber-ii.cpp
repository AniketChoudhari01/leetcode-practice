class Solution {
public:
    int dfs(vector<int>& nums, int idx, vector<int>& dp, int startIdx) {
        if(idx < startIdx) return 0;
        if(idx == startIdx) return nums[startIdx];
        if (dp[idx] != -1)  return dp[idx];

        int taken = nums[idx] + dfs(nums, idx - 2, dp, startIdx);
        int notTaken = dfs(nums, idx - 1, dp, startIdx);

        return dp[idx] = max(taken, notTaken);
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        if(n == 2) return max(nums[0], nums[1]);
        // Case 1: exclude last house
        vector<int> dp1(n, -1);
        int case1 = dfs(nums, n - 2, dp1, 0);

        // Case 2: exclude first house
        vector<int> dp2(n, -1);
        int case2 = dfs(nums, n - 1, dp2, 1);

        return max(case1, case2);
    }
};