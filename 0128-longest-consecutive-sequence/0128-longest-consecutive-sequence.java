class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int maxLen = 1;
        Arrays.sort(nums);
        int len = 1;
        for(int i=1; i<n;i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1]+1){
                len++;
                maxLen = Math.max(maxLen, len);
            }else{
                len = 1;
            }
        }
        return maxLen;
    }
}