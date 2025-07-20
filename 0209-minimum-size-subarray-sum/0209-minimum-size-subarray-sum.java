class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int n = nums.length;
        int windowSum = 0;
        while(right < n){
            windowSum += nums[right];
            while(windowSum >= target && left < n){
                len = Math.min(len, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }
        return len != Integer.MAX_VALUE ? len : 0;
    }
}