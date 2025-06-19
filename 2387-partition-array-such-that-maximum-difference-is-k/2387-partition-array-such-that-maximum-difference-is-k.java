class Solution {
    public int partitionArray(int[] nums, int k) {
        int cnt = 1;
        Arrays.sort(nums);
        int n = nums.length;
        int mini = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] - mini > k){
                mini = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}