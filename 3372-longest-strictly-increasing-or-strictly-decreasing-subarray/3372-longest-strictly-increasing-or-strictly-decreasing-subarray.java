class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxi = 1;
        int n = nums.length;
        int incLen = 1, decLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
            } else {
                incLen = 1;
            }
            if (nums[i] < nums[i - 1]) {
                decLen++;
            } else {
                decLen = 1;
            }
            maxi = Math.max(maxi, Math.max(incLen, decLen));
        }

        return maxi;
    }
}