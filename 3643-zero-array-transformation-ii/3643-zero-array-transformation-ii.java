class Solution {
    private boolean canFormZeroArray(int nums[], int[][] queries, int k){
        int n = nums.length;
        int d[] = new int[n+1];
        for(int i=0; i<k; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            d[l] += val;
            d[r+1] -= val;
        }
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += d[i];
            if(sum < nums[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0; int right = queries.length;
        if(!canFormZeroArray(nums, queries, right)) return -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canFormZeroArray(nums, queries, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}