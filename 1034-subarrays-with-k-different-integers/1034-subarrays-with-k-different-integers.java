class Solution {
    private int atMostDistinctElements(int nums[], int k) {
        int cnt = 0, total = 0;
        int n = nums.length;
        int left = 0, right = 0;
        int freq[] = new int[(int) (2e4 + 1)];
        int len = 0;
        while (right < n) {
            int elem = nums[right];
            if (freq[elem] == 0) {
                cnt++;
            }
            freq[elem]++;
            while (cnt > k && left < right) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    cnt--;
                }
                left++;
            }
            if (cnt <= k) {
                total += (right - left + 1);
            }
            right++;
        }
        return total;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostDistinctElements(nums, k) - atMostDistinctElements(nums, k - 1) ;
    }
}