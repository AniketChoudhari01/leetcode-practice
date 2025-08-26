class Solution {
public:
    int dfs(int idx, vector<int>& dp, vector<int>& nums){
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];
        if(dp[idx] != -1) return dp[idx];
        // int currRob = 0;
        // int maxRob = 0;
        // for(int j = idx - 2; j >= 0; j--){
        //     currRob += nums[idx]+dfs(j, dp, nums);
        //     cout<<"cr is "<<currRob<<"\n";
        //     maxRob += max(maxRob, currRob);
        // }
        int taken = nums[idx] + dfs(idx-2, dp, nums);
        int notTaken = dfs(idx-1, dp, nums);
        return dp[idx] = max(taken, notTaken);
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1, -1);
        // int maxRob = 0;
        // for(int i= n-1; i>=0; i--){
        //     cout<<"for idx "<<i<<"\n";
        //     maxRob = max(maxRob, dfs(i, dp, nums));
        // }
        // return maxRob;
        return dfs(n-1, dp, nums);
    }
};