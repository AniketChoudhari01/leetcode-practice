class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minElem = nums[0];
        for(int i=1; i<nums.length; i++){
            if(minElem < nums[i]){
                maxDiff = Math.max(maxDiff, nums[i] - minElem);
            }else{
                minElem = nums[i];
            }
        }
        return maxDiff;
    }
}