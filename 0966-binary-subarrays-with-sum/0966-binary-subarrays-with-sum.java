class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        int left = 0, right = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum > goal) {
                    break;
                } else if (sum == goal) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}