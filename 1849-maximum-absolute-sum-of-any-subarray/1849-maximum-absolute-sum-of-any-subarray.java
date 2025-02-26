class Solution {
    private int kadane(int[] nums) {
        // both original and reverse kadane algorithm
        int n = nums.length;
        int maxSum = 0;
        int currSum = 0;
        int currSum2 = 0;
        int minSum = Integer.MAX_VALUE;// reverse kadane
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            currSum2 += nums[i];
            maxSum = Math.max(maxSum, Math.max(nums[i], currSum));
            minSum = Math.min(minSum, Math.min(nums[i], currSum2));
            if (currSum < 0)
                currSum = 0;
            if (currSum2 > 0)
                currSum2 = 0;
        }
        return Math.max(maxSum, Math.abs(minSum));
    }

    public int maxAbsoluteSum(int[] nums) {
        return kadane(nums);
    }
}