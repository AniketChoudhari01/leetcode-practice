class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1) return 1;
        int inc_len = 1;
        int dec_len = 1;
        int n = nums.length;
        int maxi = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                inc_len ++;
                dec_len = 1;
                maxi = Math.max(maxi, Math.max(inc_len, dec_len));
            }else if(nums[i] < nums[i-1]){
                dec_len++;
                inc_len = 1;
                maxi = Math.max(maxi, Math.max(inc_len, dec_len));
            }else{
                dec_len = 1;
                inc_len = 1;
            }
        }
        return maxi;
    }
}