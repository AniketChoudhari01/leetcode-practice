class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 1)
            return 0;
        long prod = 1;
        int n = nums.length;
        int left = 0, right = 0;
        int subarrays = 0;
        int len = 0;
        while (right < n) {
            // while (right < n && nums[right] * prod < k) {// expand window
            // prod *= nums[right];
            // subarrays += (right - left + 1);
            // right++;
            // }
            prod *= nums[right]; //expand things 
            while (left < right && prod >= k) { //shrink untill the condition is met again
                prod /= nums[left];
                left++;
            }
            if (prod < k) {
                subarrays += (right - left + 1);//counting all the subarray in the range
            }
            right++;
        }
        // if (prod < k) {
        //     subarrays += (right - left + 1);
        // }
        return subarrays;
    }
}