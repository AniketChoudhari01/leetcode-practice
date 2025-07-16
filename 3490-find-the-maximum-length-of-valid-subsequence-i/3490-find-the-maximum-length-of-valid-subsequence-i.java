class Solution {
    private int findAlternateLength(int nums[], int curr, int startIdx){
        int len = 1;
        for(int i = startIdx+1; i<nums.length; i++){
            int elem = nums[i];
            if(curr != elem){
                len++;
                curr = elem;
            }
        }
        return len;
    }
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int cnt1s = 0, cnt0s = 0;
        int firstZeroIdx = -1;
        int firstOneIdx = -1;
        for(int i=0; i<n; i++){
            nums[i] %= 2;
            if(nums[i] == 0){
                if(firstZeroIdx == -1){
                    firstZeroIdx = i;
                }
                cnt0s++;
            }else{
                if(firstOneIdx == -1){
                    firstOneIdx = i;
                }
                cnt1s++;
            }
        }
        // System.out.println(Arrays.toString(nums));
        int pickZeroStart = findAlternateLength(nums, 0, firstZeroIdx);
        int pickOneStart = findAlternateLength(nums, 1, firstOneIdx);
        // System.out.println("zero "+pickZeroStart+ " one "+pickOneStart);
        int maxi = Math.max(Math.max(cnt1s, cnt0s), Math.max(pickZeroStart, pickOneStart));
        return maxi;
    }
}