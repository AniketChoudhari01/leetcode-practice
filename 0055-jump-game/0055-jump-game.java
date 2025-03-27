class Solution {
    Boolean isPossible[];
    private boolean jump(int nums[], int start){
        if(start >= nums.length - 1){
            return true;
        }
        if(isPossible[start] != null){
            return isPossible[start]; // return the cached result
        }

        if(nums[start] == 0){
            return isPossible[start] = false;//not possible
        }
        int maxJump = Math.min(start + nums[start], nums.length-1);
        for(int i=start + 1; i<=maxJump; i++){
            if (jump(nums, i)) {
                return isPossible[start] = true;
            }
        }
        return isPossible[start] = false;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        isPossible = new Boolean[nums.length];
        return jump(nums, 0);
    }
}