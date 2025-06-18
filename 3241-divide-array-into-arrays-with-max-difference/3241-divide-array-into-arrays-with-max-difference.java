class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length / 3;
        int ans[][] = new int[n][3];
        Arrays.sort(nums);
        int min = nums[0];
        int idx = 0;int j = 0;
        for(int i=1; i<nums.length; i++){
            if(i % 3 == 0){
                min = nums[i];
                ans[j++] = Arrays.copyOfRange(nums, idx, i);
                idx = i;
                continue;
            }
            if(nums[i] - min > k) return new int[][]{};
        }
        ans[j] = Arrays.copyOfRange(nums, idx, nums.length);
        return ans;
    }
}