
class Solution {

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // LIS from left to right
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        
        // LDS from right to left
        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        
        // Find the maximum mountain sequence length
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {  // Check for valid mountain peak
                maxMountainLength = Math.max(maxMountainLength, LIS[i] + LDS[i] - 1);
            }
        }

        return n - maxMountainLength;  // Minimum removals to achieve a mountain array
    }
}
