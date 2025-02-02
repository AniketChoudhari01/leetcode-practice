class Solution {
    public boolean check(int[] nums) {
        int cntPeaks = 0;
        int n = nums.length;
        int idx = 0;
        for(int i=1; i<n; i++){
            if(nums[i]<nums[i-1]){
                cntPeaks++;
                idx = i;
            }
        }
        if(cntPeaks>1) return false;
        if(idx==0) return true;
        for(int i=(idx+1)%n, j=idx; i!=idx; i=(i+1)%n, j=(j+1)%n){
            if(nums[j] > nums[i]){
                return false;
            }
            // System.out.println(i+" , "+j);
        }
        return true;
    }
}