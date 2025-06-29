class Solution {
    // private int lowerBound(int low, int high, int x, int nums[]){
    //     if(low > high) return high;
    //     int mid = low + (high-low)/2;
    //     if(nums[mid] <= x){
    //         return lowerBound(mid+1, high, x, nums);
    //     }else{
    //         return lowerBound(low, mid-1, x, nums);
    //     }
    // }
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int MOD = (int)1e9+7;
        Arrays.sort(nums);
        int powerOfTwo[] = new int[n];
        powerOfTwo[0] = 1;
        for(int i=1; i<n; i++){
            powerOfTwo[i] = (powerOfTwo[i-1]*2)%MOD;
        }
        int ans = 0;
        int left = 0, right = n-1;
        while(left <= right){
            if(nums[left]+nums[right] <= target){
                ans = (ans + powerOfTwo[right-left])%MOD;
                left++;
            }else{
                right--;
            }
        }
        // for(int i=0; i<n; i++){
        //     int j = lowerBound(i+1, n-1, target - nums[i], nums);
        //     // if(j < i) continue;
        //     if(i == j){
        //         if(nums[i]*2 <= target){
        //             ans = (ans + 1)%MOD;
        //         }
        //     }else{
        //         ans = (ans + powerOfTwo[j-i])%MOD;
        //     }
        //     // System.out.println(j);
        // }
        return ans;
    }
}