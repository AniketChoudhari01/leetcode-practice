class Solution {
    public long maximumProduct(int[] nums, int m) {
        long maxProd = Long.MIN_VALUE;
        int n = nums.length;
        if(m == 1){
            for(int val: nums){
                maxProd = Math.max(maxProd, val*(long)val);
            }
            return maxProd;
        }
        long mini = Long.MAX_VALUE, maxi = Long.MIN_VALUE;
        for(int i=m-1; i<n; i++){ //for every possible end index multiply with possible start element
            mini = Math.min(mini, nums[i-(m-1)]);
            maxi = Math.max(maxi, nums[i-(m-1)]);
            maxProd = Math.max(maxProd, Math.max(mini*nums[i], maxi*nums[i]));
        }
        return maxProd;
    }
}