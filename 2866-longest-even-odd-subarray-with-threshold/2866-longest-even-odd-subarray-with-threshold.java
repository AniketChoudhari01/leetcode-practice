class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int maxLen = 0, currLen = 0;
        int curr = -1;
        for (int i = 0; i < n; i++) {
            if (curr == -1 && nums[i] % 2 == 1) {
                continue;
            }
            if (nums[i] > threshold) {
                maxLen = Math.max(maxLen, currLen);
                currLen = 0;
                curr = -1;
                continue;
            }
            if (curr != (nums[i] % 2)) {
                curr = nums[i] % 2;
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
                if (nums[i] % 2 != 0) {
                    currLen--;
                }
            }
        }
        return Math.max(maxLen, currLen);
    }
}