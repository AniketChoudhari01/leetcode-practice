class Solution {
    public int numOfSubarrays(int[] arr) {
        int ans  = 0;
        int n = arr.length;
        int MOD = (int)1e9+7;
        int prefixSum = 0;
        int evenCnt = 1, oddCnt = 0;//since intialized sum to 0
        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            if(prefixSum % 2 == 0){
                evenCnt ++;
                ans = (ans + oddCnt)%MOD;
            }else{
                oddCnt ++;
                ans = (ans + evenCnt)%MOD;
            }
        }

        return ans;
    }
}