class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int freq[] = new int[501];
        for(int i=0; i<n; i++){
            freq[nums[i]]++;
        }
        int cnt = 0;
        int pairs = n / 2;
        for(int i=0; i<freq.length; i++){
            cnt += freq[i]/2;
        }
        return cnt == pairs;
    }
}