class Solution {
public:
    int dfs(int idx, int target, vector<int> &nums){
        //BASE CASES
        if(idx < 0){
            //here we have selected all the possible value of answer then it should return true
            //if it turns the target to 0 else 1
            return (target == 0)? 1 : 0;
        }

        int negative = dfs(idx-1, target-nums[idx], nums);
        int positive = dfs(idx-1, target+nums[idx], nums);
        return negative + positive;
    }
    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        return dfs(n-1, target, nums);
    }
};