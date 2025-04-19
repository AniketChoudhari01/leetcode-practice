class Solution {
    private int upperBound(int nums[], int low, int high, int target) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return upperBound(nums, low, mid - 1, target);
        } else {
            return upperBound(nums, mid + 1, high, target);
        }
    }

    private int lowerBound(int nums[], int low, int high, int target) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] < target) {
            return lowerBound(nums, mid + 1, high, target);
        } else {
            return lowerBound(nums, low, mid - 1, target);
        }
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int low = lower - nums[i];
            int high = upper - nums[i];
            int left = lowerBound(nums, i + 1, n - 1, low);
            int right = upperBound(nums, i + 1, n - 1, high);
            // System.out.println(left+" , "+right);
            count += (right - left);
        }
        return count;
    }
}