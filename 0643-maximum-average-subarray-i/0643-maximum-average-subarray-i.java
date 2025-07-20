class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Double.NEGATIVE_INFINITY;
        int n = nums.length, left = 0, right = 0;
        double windowSum = 0;
        while(right < n){
            windowSum += nums[right];
            if(right >= k-1){
                ans = Math.max(windowSum/k, ans);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }
        return ans;
    }
}