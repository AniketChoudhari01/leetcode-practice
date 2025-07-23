class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestSum = 0;
        int smallestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left < right){
                int targetDiff = target - (nums[i] + nums[left] + nums[right]);
                if(targetDiff == 0){
                    return target;
                }
                if(Math.abs(smallestDiff) > Math.abs(targetDiff)){
                    smallestDiff = targetDiff;
                }
                if(targetDiff > 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return target - smallestDiff;
    }
}