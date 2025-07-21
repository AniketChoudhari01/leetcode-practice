class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int ones = 0;
        int concecutiveOne = 0;
        int windowSize = 0;
        while(right < n){
            ones += nums[right];
            windowSize = right - left + 1;
            if(windowSize - ones > k){
                ones -= nums[left];
                left++;
            }
            concecutiveOne = Math.max(concecutiveOne, right - left +1);
            right++;
        }
        return concecutiveOne;
    }
}