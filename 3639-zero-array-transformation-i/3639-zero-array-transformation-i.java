class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int d[] = new int[n+1];
        for(int arr[]:queries){
            d[arr[0]]++;
            d[arr[1]+1]--;
        }
        int sum = 0;
        // for(int i=0;i<n+1; i++){//doing prefix sum
        //     sum += d[i];
        //     d[i] = sum;
        // }
        for(int i=0; i<n; i++){
            sum += d[i];
            // if(d[i] < nums[i]) return false;
            if(sum < nums[i]) return false;
        }
        return true;
    }
}