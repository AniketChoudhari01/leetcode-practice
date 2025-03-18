class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int n = nums.length;
        int left = 0, right = 0;
        int usedBits = 0;
        while (right < n) {
            // while(right < n && (usedBits & nums[right]) != 0){//expand till satisfys
            //     //means no overlapping bits 
            //     usedBits ^= nums[right];
            //     right++;
            // }
            //xor with all the elements 
            //unitll it doesnot satisfy the condition of and == 0 shrink the window from left half
            //then compare the ans with max len
            while(left < right && (usedBits&nums[right]) != 0){//shrink due to  bits overlaps
                usedBits ^= nums[left];
                left++;
            }
            usedBits |= nums[right];
            ans = Math.max(ans, right - left+1);
            right++;
        }
        return ans;
    }
}