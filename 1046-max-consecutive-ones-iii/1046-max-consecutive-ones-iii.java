    class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) {
            return n;
        }
        List<Integer> storeIdx = new ArrayList<>();
        int nextZeroIdx = -1;
        int maxLen = 0;
        int cnt = 0, right = 0, left = 0;
        while (right < n) {
            if (nums[right] == 0) {
                cnt++;
                storeIdx.add(right);
                if(cnt > k){
                    maxLen = Math.max(maxLen, right - left);
                    System.out.println("l:" + left + " r: " + right + "max: " + maxLen);
                    left = storeIdx.get(0) + 1;
                    storeIdx.remove(0);
                    // while(left < n && cnt > k){
                    //     if(nums[left] == 0){
                    //         cnt--;
                    //     }
                    //     left++;
                    // }
                }
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }
}