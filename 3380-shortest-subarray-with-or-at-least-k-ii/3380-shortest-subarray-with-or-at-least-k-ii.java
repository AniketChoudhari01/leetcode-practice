class Solution {
    private void updateBitCounts(int[] bitCounts, int number, int delta) {
        for (int i = 0; i < 32; i++) {
            if (((number >> i) & 1) != 0) {
                bitCounts[i] += delta;
            }
        }
    }

    private int convertBitsToNumber(int bitCounts[]) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCounts[i] != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int bitCounts[] = new int[32];
        while (right < nums.length) {
            updateBitCounts(bitCounts, nums[right], 1);
            while (left <= right && convertBitsToNumber(bitCounts) >= k) {
                minLength = Math.min(minLength, right - left + 1);
                updateBitCounts(bitCounts, nums[left], -1);
                left++;
            }
            // need to shrink from left and from right
            right++;

        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}