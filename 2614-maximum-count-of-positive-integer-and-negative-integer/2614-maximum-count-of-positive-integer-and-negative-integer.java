class Solution {
    private int lowerBound(int nums[], int target, int low, int high){
        if(low > high) return low;
        int mid = low + (high - low)/2;
        if(nums[mid] <= target){
            return lowerBound(nums, target, mid + 1, high);
        }else{
            return lowerBound(nums, target, low, mid-1);
        }
    }
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int idx1 = lowerBound(nums, 0, 0, n-1);
        int idx2 = lowerBound(nums, -1, 0, n-1);
        return Math.max(n-idx1, idx2);
    }
}