class Solution {
    int dp[];

    private int minJumps(int idx, int nums[]) {
        if (idx >= nums.length - 1) {
            // dp[idx] = 0;
            return 0;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int currLevelMinJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            int jumps = minJumps(i + idx, nums);
            if (jumps != Integer.MAX_VALUE) {
                currLevelMinJumps = Math.min(currLevelMinJumps, 1 + jumps);
            }
        }
        dp[idx] = currLevelMinJumps;
        return dp[idx];
    }

    public int jump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int res = minJumps(0, nums);
        // System.out.println(Arrays.toString(dp));
        return res;
    }
}