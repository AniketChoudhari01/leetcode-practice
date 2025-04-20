class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long result[] = new long[k];
        int prevCnt[] = new int[k];
        for(int i=0; i<n; i++){
            int currCnt[] = new int[k];
            currCnt[nums[i]%k]++;
            //adding the i-1 if present
            for(int j=0; j<k; j++){
                if(prevCnt[j] != 0){
                    int newRemainder = (j*(nums[i]%k))%k;
                    currCnt[newRemainder] += prevCnt[j];
                }
            }
            //update the final result and the prevCnt
            for(int j=0; j<k; j++){
                result[j] += currCnt[j];
                prevCnt[j] = currCnt[j];
            }
        }
        return result;
    }
}