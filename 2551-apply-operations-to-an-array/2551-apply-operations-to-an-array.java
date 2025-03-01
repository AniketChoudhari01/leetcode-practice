class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        int left = 0, right = 0;
        while (left < n) {
            while (left < n) {
                if (nums[left] == 0) {
                    break;
                }
                left++;
            }
            right = left + 1;
            while (right < n) {
                if (nums[right] != 0) {
                    break;
                }
                right++;
            }
            if (left < n && right < n) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
        }
        return nums;
    }
}