class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int maxBeauty = 1;
        int left=0;
        int maxi=Integer.MIN_VALUE;
        for(int right = 0; right<nums.length; right++){
            if((nums[right]-nums[left])>(2*k)){
                left++;
            }
            maxi=Math.max(maxi, right-left+1);
        }
        return maxi;
    }
}
