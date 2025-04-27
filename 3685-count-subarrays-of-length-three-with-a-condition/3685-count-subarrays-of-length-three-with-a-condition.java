class Solution {
    public int countSubarrays(int[] nums) {
        int cnt = 0, n = nums.length;
        for(int i=0; i<n-2; i++){
            if(2*(nums[i] + nums[i+2]) == nums[i+1]) cnt++;
        }
        return cnt;
    }
}