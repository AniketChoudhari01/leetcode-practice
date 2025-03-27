class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1) return 1;
        int len = 1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(j==i) continue;
                if(nums[j] <= nums[j-1]){
                    break;
                }
                len = Math.max(len, j-i+1);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(j==i) continue;
                if(nums[j] >= nums[j-1]){
                    break;
                }
                len = Math.max(len, j-i+1);
            }
        }
        return len;
    }
}