class Solution {
    private boolean isNiceSubarray(int nums[], int mid) {
        if (mid <= 1)
            return true;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isNice = true;
            int mask = 0;
            if (i + mid > n) {
                return false;
            }
            for (int j = i; j < n && j < i + mid; j++) {
                if ((mask & nums[j])!= 0) { //check if there is any overlapping bit in this
                    isNice = false;
                    break;
                }
                mask |= nums[j];//to carry the unique bits from this number to next num 
            }
            if (isNice) {
                return true;
            }
        }
        return false;
    }

    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int n = nums.length;
        // [1, 3, 8, 48, 10]
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isNiceSubarray(nums, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}