class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int n = nums.length;
        int cntOnes = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                cntOnes++;
                maxOnes = Math.max(maxOnes, cntOnes);
            }else{
                cntOnes = 0;
            }
        }
        return maxOnes;
    }
}