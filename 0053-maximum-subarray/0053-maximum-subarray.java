class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (currSum < 0 && left < right) {
                currSum -= nums[left++];
            }
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
            right++;
        }
        return maxSum;
    }
}