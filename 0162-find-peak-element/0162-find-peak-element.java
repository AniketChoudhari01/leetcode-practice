class Solution {
    public int findPeakElement(int[] nums) {
        int peak_idx = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[peak_idx] < nums[i]){
                peak_idx = i;
            }
        }
        return peak_idx;
    }
}