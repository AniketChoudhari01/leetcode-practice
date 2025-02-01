class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) {
            return n;
        }
        // List<Integer> storeIdx = new ArrayList<>(); expensive due to left shift of elements o(n) time
        Deque<Integer> queue = new ArrayDeque<>();
        int maxLen = 0;
        int cnt = 0, right = 0, left = 0;
        while (right < n) {
            if (nums[right] == 0) {
                cnt++;
                queue.offer(right);
                if (cnt > k) {
                    maxLen = Math.max(maxLen, right - left);
                    left = queue.poll() + 1;
                }
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }
}