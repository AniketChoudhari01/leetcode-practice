class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxFreq = 0;
        int left = 0, right = 0;
        // long prefixSum[] = new long[n];
        // prefixSum[0] = nums[0];
        // for(int i=1; i<n; i++){
        //     prefixSum[i] += (prefixSum[i-1]+nums[i]);
        // }
        long currSum = 0;
        while(right < n){
            // currSum = ((left > 0)?( prefixSum[right]-prefixSum[left-1]) : prefixSum[right]);
            long target = nums[right];
            currSum += target;
            while(currSum + k < (target)*(right-left+1)){
                currSum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right-left+1);
            right++;
        }
        return maxFreq;
    }
}