class Solution {
    private int findMaxRob(int nums[], int i, int dp[]){
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.max(findMaxRob(nums, i-1, dp), nums[i] + findMaxRob(nums, i-2, dp));
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int sum = 0;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return findMaxRob(nums, n-1, dp);
    }
}