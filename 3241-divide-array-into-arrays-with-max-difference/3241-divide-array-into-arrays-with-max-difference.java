class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length / 3;
        int ans[][] = new int[n][3];
        Arrays.sort(nums);
        int min = -1;
        for(int i=0; i<nums.length; i++){
            if(i % 3 == 0){
                min = nums[i];
                continue;
            }
            if(nums[i] - min > k) return new int[0][0];
        }
        int idx = 0;
        for(int i=0; i<n; i++){
            ans[i] = Arrays.copyOfRange(nums, idx, idx + 3);
            idx += 3;
        }
        return ans;
    }
}