class Solution {
    // private int slidingWindowAtMost(int nums[], int goal) {
    // int n = nums.length;
    // int currSum = 0, total = 0;
    // int right = 0, left = 0;
    // while (right < n && left < n) {
    // currSum += nums[right++];
    // while (left < right && currSum > goal) {
    // currSum -= nums[left++];
    // }
    // total += (right - left + 1);
    // }
    // return total;
    // }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int right = 0, left = 0;
        int total = 0, prefixZeros = 0, currSum = 0;
        while (right < n) {
            currSum += nums[right];
            while (left < right && ( nums[left]==0|| currSum > goal)) {
                if (nums[left] == 0)
                    prefixZeros++;
                else
                    prefixZeros = 0;
                currSum -= nums[left];
                left++;
            }
            if (currSum == goal) {
                total += (1 + prefixZeros);
            }
            right++;
        }
        return total;
        // return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}