class Solution {

    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];

        int prevSegMax = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) {
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else {
                if (prevSegMax > minOfSegment) {
                    return false;
                }
                prevSegMax = maxOfSegment;
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                numOfSetBits = Integer.bitCount(nums[i]);
            }
        }
        if (prevSegMax > minOfSegment) {
            return false;
        }
        return true;
    }
}
