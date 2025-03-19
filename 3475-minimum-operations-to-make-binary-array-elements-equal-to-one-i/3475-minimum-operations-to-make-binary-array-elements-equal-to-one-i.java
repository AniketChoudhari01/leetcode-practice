class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if(nums[i] == 1){
                continue;
            }
            int cnt1 = 0;
            for (int j = i; j < i + 3; j++) {// window
                if (nums[j] == 1)
                    cnt1++;
            }
            if (cnt1 != 3) {
                for (int j = i; j < i + 3; j++) {// window
                    nums[j] ^= 1;
                }
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != 1)
                return -1;
        }
        return ans;
    }
}