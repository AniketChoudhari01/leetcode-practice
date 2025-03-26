class Solution {
    public int minMoves2(int[] nums) {
        int min_moves = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int median=0;
        if(n % 2 == 0){
            median = (nums[(n-1)/2] + nums[n/2])/2;
        }else{
            median = nums[n/2];
        }
        // System.out.println(median);
        for(int num: nums){
            min_moves += Math.abs(median - num);
        }
        return min_moves;
    }
}