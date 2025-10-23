class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int posIdx = 0, negIdx = 1;
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            int idx = -1;
            if(nums[i] > 0){
                idx = posIdx;
                posIdx += 2;
            }else{
                idx = negIdx;
                negIdx += 2;
            }
            ans[idx] = nums[i];
        }
        return ans;
    }
}