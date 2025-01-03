class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        double prefixSum [] = new double[n];
        double total = 0;
        double noOfWays = 0;
        for(int i=0; i<n ;i++){
            total+=nums[i];
            prefixSum[i] = total;
        }
        for(int i = 0; i<n-1; i++){
            if(prefixSum[i] >= (total - prefixSum[i])){
                noOfWays++;
            }
        }
        return (int)noOfWays;
    }
}